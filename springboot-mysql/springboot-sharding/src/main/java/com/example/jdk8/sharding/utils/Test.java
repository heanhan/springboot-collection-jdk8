//package com.example.jdk8.sharding.utils;
//
//
//import org.apache.ibatis.javassist.CannotCompileException;
//import org.apache.ibatis.javassist.ClassPool;
//import org.apache.ibatis.javassist.CtClass;
//import org.apache.ibatis.javassist.CtMethod;
//import org.apache.ibatis.javassist.NotFoundException;
//
//import java.io.File;
//import java.io.IOException;
//import java.lang.reflect.Modifier;
//import java.util.Arrays;
//
///**
// * @description 用来测试生成破解的  mybatisgeneratorpro 的插件破解class 文件
// * @version 1.0
// * @author zhaojh
// * @date 2024/10/31 下午5:53
// */
//public class Test {
//
//    public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException {
//        File oldJar = new File("/Users/zhaojh/Downloads/MyBatisCodeHelper-Pro/lib/instrumented-MyBatisCodeHelper-Pro241-3.3.6+2321.jar");
//        String decodeClassFullName = "com.ccnode.codegenerator.af.f.e";
//        String jarDir = oldJar.getParent();
//
//// 加载类
//        ClassPool classPool = ClassPool.getDefault();
//// 添加需要修改和所依赖的Jar包
//        classPool.appendClassPath(oldJar.getAbsolutePath());
//        classPool.appendClassPath("/Users/zhaojh/Downloads/MyBatisCodeHelper-Pro/lib/gson-2.11.0.jar");
//        classPool.appendClassPath("/Users/zhaojh/Downloads/MyBatisCodeHelper-Pro/lib/jettison-1.5.4.jar");
//
//// 获取需要修改的解码类
//        CtClass decodeCtClass = classPool.get(decodeClassFullName);
//// 解码类的解码方法并修改
//        CtMethod decodeCtMethod = Arrays.stream(decodeCtClass.getDeclaredMethods())
//                .filter(method -> {
//                    try {
//                        return Modifier.isPublic(method.getModifiers())
//                                && method.getParameterTypes().length == 1
//                                && String.class.getSimpleName().equals(method.getParameterTypes()[0].getSimpleName());
//                    } catch (NotFoundException e) {
//                        throw new RuntimeException(e);
//                    }
//                }).findFirst().orElseThrow(null);
//        String returnType = decodeCtMethod.getReturnType().getName();
//        decodeCtMethod.setBody("{"
//                // 添加 userMac、valid、validTo、paidKey 属性值
//                + " org.codehaus.jettison.json.JSONObject jsonObject;"
//                + " try {"
//                + "     jsonObject = new org.codehaus.jettison.json.JSONObject($1);"
//                + " } catch (Exception e) {"
//                + "     jsonObject = new org.codehaus.jettison.json.JSONObject();"
//                + " }"
//                + " if (!jsonObject.has(\"userMac\") || jsonObject.get(\"userMac\") == null) {"
//                + "     String macAddress;"
//                + "     try {"
//                + "         java.net.InetAddress ip = java.net.InetAddress.getLocalHost();"
//                + "         java.net.NetworkInterface network = java.net.NetworkInterface.getByInetAddress(ip);"
//                + "         byte[] mac = network.getHardwareAddress();"
//                + "         StringBuilder stringBuilder = new StringBuilder();"
//                + "         for (int i = 0; i < mac.length; i++) {"
//                + "             byte b = mac[i];"
//                + "             stringBuilder.append(Character.forDigit((b >> 4) & 0xF, 16));"
//                + "             stringBuilder.append(Character.forDigit(b & 0xF, 16));"
//                + "             stringBuilder.append(\"-\");"
//                + "         }"
//                + "         macAddress = stringBuilder.substring(0, stringBuilder.length() - 1).toUpperCase();"
//                + "     } catch (Exception e) {"
//                + "         macAddress = \"00-00-00-00-00-00\";"
//                + "     }"
//                + "     jsonObject.put(\"userMac\", macAddress);"
//                + " }"
//                + " jsonObject.put(\"valid\", true);"
//                + " jsonObject.put(\"validTo\", 4102415999000L);"
//                + " jsonObject.put(\"paidKey\", java.util.UUID.randomUUID().toString());"
//                + " $1 = jsonObject.toString();"
//                // 将Json字符串转换成指定对象
//                + "com.google.gson.Gson gson = new com.google.gson.Gson();"
//                + returnType + " result = (" + returnType + ")gson.fromJson($1," + returnType + ".class);"
//                + "return result;"
//                + "}");
//// 将修改后的解码类文件写到本地
//        decodeCtClass.writeFile(jarDir);
//
//// 修改强制退出类
//        String exitClassFullName = "com.ccnode.codegenerator.myconfigurable.Profile";
//        CtClass exitCtClass = classPool.get(exitClassFullName);
//        exitCtClass.getDeclaredMethod("getIfUseNewMapping").setBody("{return 1;}");
//// 将修改后的解码类文件写到本地
//        exitCtClass.writeFile(jarDir);
//    }
//}
