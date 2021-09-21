//    package com.example.androidkeystoredemo;
//
//    import java.net.MalformedURLException;
//    import java.net.URI;
//    import java.net.URISyntaxException;
//    import java.net.URL;
//    import java.util.HashMap;
//    import java.util.Map;
//    import java.util.regex.Pattern;
//
//    public class Demo {
//
//        // Online Java Compiler
//    // Use this editor to write, compile and run your Java code online
//    // Java program to show the use of the function getQuery()
//
//            // private static String GetSubDomain(String stringurl)
//            // {
//            //     URL url = null;
//            //     try {
//            //         url = new URL(stringurl);
//            //     }catch (MalformedURLException urlException){
//            //         urlException.printStackTrace();
//            //     }
//            //     String host = url.getHost().toString();
//            //     Pattern p = Pattern.compile(“[.]“);
//            //     String u[]=p.split(url.getAuthority());
//            //     if (u.length > 2)
//            //     {
//            //         int lastIndex = host.lastIndexOf(“.”);
//            //         int index = host.lastIndexOf(“.”, lastIndex - 1);
//            //         return host.substring(0, index);
//            //     }
//            //     return null;
//            // }
//
//
//            public static Map<String, String> getQueryMap(String query) {
//                String[] params = query.split("&");
//                Map<String, String> map = new HashMap<String, String>();
//
//                for (String param : params) {
//                    String name = param.split("=")[0];
//                    String value = param.split("=")[1];
//                    map.put(name, value);
//                }
//                System.out.println("map = " +map);
//                return map;
//            }
//
//            public static void main(String args[])
//            {
//                // uri  object
//                URI uri = null;
//
//                try {
//                    // create a URI
//                    uri = new URI("paytmmp://mpordersummary?url=https://paytmstores.com.apanaresult.com/paytm_test.html?collaborator_url=YOUR_COLLABORATOR_ADDRESS");
//
//                    GetSubDomain("paytmmp://mpordersummary?url=https://paytmstores.com.apanaresult.com/paytm_test.html&collaborator_url=YOUR_COLLABORATOR_ADDRESS");
//                    // get the  Query
//                    String _Query = uri.getQuery();
//
//                    // display the URL
//                    System.out.println("URI = " + uri);
//
//                    // display the  Query
//                    System.out.println(" Query=" + _Query);
//
//                    getQueryMap(_Query);
//
//
//
//                }
//                // if any error occurs
//                catch (URISyntaxException e) {
//                    // display the error
//                    System.out.println("URI Exception =" + e.getMessage());
//                }
//            }
//
//
//        private static String GetSubDomain(String stringurl)
//        {
//            URL url = null;
//            try {
//                url = new URL(stringurl);
//            }catch (MalformedURLException urlException){
//                urlException.printStackTrace();
//            }
//            String host = url.getHost().toString();
//            Pattern p = Pattern.compile(“[.]“);
//            String u[]=p.split(url.getAuthority());
//            if (u.length > 2)
//            {
//                int lastIndex = host.lastIndexOf(“.”);
//                int index = host.lastIndexOf(“.”, lastIndex - 1);
//                return host.substring(0, index);
//            }
//            return null;
//        }
//    }
