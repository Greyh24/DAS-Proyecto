
package com.uwiener.das.javaweb;

import java.util.HashSet;
import java.util.Set;

public class VHtml {
    private String Header;
    private String Body;
    private String Footer;
    

    public VHtml(){
        this.setHeader("<!doctype html>\n" +
                        "<html class=\"no-js\" lang=\"\"> <!--<![endif]-->\n" +
                        "    <head>\n" +
                        "        <meta charset=\"utf-8\">\n" +
                        "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n" +
                        "        <title>Desarrollo de Aplicaciones en Salud</title>\n" +
                        "        <meta name=\"description\" content=\"\">\n" +
                        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "        <link rel=\"apple-touch-icon\" href=\"apple-touch-icon.png\">\n" +
                        "\n" +
                        "        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n" +
                        "        <style>\n" +
                        "            body {\n" +
                        "                padding-top: 50px;\n" +
                        "                padding-bottom: 20px;\n" +
                        "            }\n" +
                        "        </style>\n" +
                        "        <link rel=\"stylesheet\" href=\"webjars/bootstrap/5.2.2/css/bootstrap.css\">\n" +
                        "    </head>");
        
        this.setFooter("        </div>\n" +
                        "        <div class=\"col-md-3\"></div>\n" +
                        "      </div>      \n" +
                        "      <footer>\n" +
                        "        <p class=\"center\">&copy; Company 2023</p>\n" +
                        "      </footer>\n" +
                        "    </div> \n" +
                        "        <!-- /container -->        \n" +
                        "        <script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n" +
                        "        <script>window.jQuery || document.write('<script src=\"js/vendor/jquery-1.11.2.min.js\"><\\/script>')</script>\n" +
                        "\n" +
                        "        <script src=\"js/vendor/bootstrap.min.js\"></script>\n" +
                        "\n" +
                        "        <script src=\"js/main.js\"></script>\n" +
                        "\n" +
                        "        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->\n" +
                        "        <script>\n" +
                        "            (function(b,o,i,l,e,r){b.GoogleAnalyticsObject=l;b[l]||(b[l]=\n" +
                        "            function(){(b[l].q=b[l].q||[]).push(arguments)});b[l].l=+new Date;\n" +
                        "            e=o.createElement(i);r=o.getElementsByTagName(i)[0];\n" +
                        "            e.src='//www.google-analytics.com/analytics.js';\n" +
                        "            r.parentNode.insertBefore(e,r)}(window,document,'script','ga'));\n" +
                        "            ga('create','UA-XXXXX-X','auto');ga('send','pageview');\n" +
                        "        </script>\n" +
                        "    </body>\n" +
                        "</html>\n" +
                        "");
        this.setBody("<body>\n" +
                        "    <div class=\"container\">\n" +
                        "      <!-- Example row of columns -->\n" +
                        "      <div class=\"row\">\n" +
                        "        <div class=\"col-md-3\"></div>\n" +
                        "        <div class=\"col-md-6\">");
    }

    public String getHeader() {
        return Header;
    }

    public void setHeader(String Header) {
        this.Header = Header;
    }

    public String getFooter() {
        return Footer;
    }


    public void setFooter(String Footer) {
        this.Footer = Footer;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String Body) {
        this.Body = Body;
    }
}
