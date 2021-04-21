package jvm;

public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        //class的绝对路径
//        File file = new File(name);
//        FileInputStream fis = new FileInputStream(file);
//        int len = 0;
//        ByteArrayOutputStream byteAOS = new ByteArrayOutputStream();
//        while (true){
//            try {
//                if (!(len = fis.read())!=-1)){
//                        break;
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
    return null;
    }
}
