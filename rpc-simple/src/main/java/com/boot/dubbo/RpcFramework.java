package com.boot.dubbo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * com.boot.dubbo.RpcFramework
 *
 * @author lipeng
 * @dateTime 2018/10/27 下午5:51
 */
public class RpcFramework {

    public static final Integer MIN_PORT = 0;

    public static final Integer MAX_PORT = 65535;

    public static void export(Object service, Integer port) throws IOException {
        if (null == service) {
            throw new IllegalArgumentException("parameter service can not be null");
        }
        if (port <= MIN_PORT && port > MAX_PORT) {
            throw new IllegalArgumentException("parameter port should be between 0 and 65535");
        }

        ServerSocket serverSocket = new ServerSocket(port);
        final Socket socket = serverSocket.accept();
        new Thread(() -> {
            try {
                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                    try {
                        String methodName = objectInputStream.readUTF();
                        Class<?>[] parameterType = (Class<?>[]) objectInputStream.readObject();
                        Object[] arguments = (Object[]) objectInputStream.readObject();
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        try {
                            Method method = service.getClass().getMethod(methodName, parameterType);
                            Object result = method.invoke(service, arguments);
                            System.out.println("调用" + service.getClass().getName() + "的" + methodName + "方法，返回结果：" + result);
                            objectOutputStream.writeObject(result);
                        } catch (InvocationTargetException e) {
                            objectOutputStream.writeObject(e);
                        } finally {
                            objectOutputStream.close();
                        }
                    } finally {
                        objectInputStream.close();
                    }
                } finally {
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static <T> T refer(final Class<T> interfaceClass, final String host, final Integer port) {
        if (null == interfaceClass) {
            throw new IllegalArgumentException("interfaceClass can not be null");
        }

        if (!interfaceClass.isInterface()) {
            throw new IllegalArgumentException("the" + interfaceClass.getName() + "must be interface");
        }

        if (null == host || host == "") {
            throw new IllegalArgumentException("host can not be null");
        }

        if (null == port) {
            throw new IllegalArgumentException("port can not be null");
        }

        if (port <= MIN_PORT || port > MAX_PORT) {
            throw new IllegalArgumentException("parameter port should be between 0 and 65535");
        }
        System.out.println("Get remote service " + interfaceClass.getName() + " from server " + host + ":" + port);
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, (proxy, method, args) -> {
            Socket socket = new Socket(host, port);
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                try {
                    objectOutputStream.writeUTF(method.getName());
                    objectOutputStream.writeObject(method.getParameterTypes());
                    objectOutputStream.writeObject(args);

                    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                    try {
                        Object result = objectInputStream.readObject();
                        return result;
                    } finally {
                        objectInputStream.close();
                    }
                } finally {
                    objectOutputStream.close();
                }
            } finally {
                socket.close();
            }
        });
    }
}
