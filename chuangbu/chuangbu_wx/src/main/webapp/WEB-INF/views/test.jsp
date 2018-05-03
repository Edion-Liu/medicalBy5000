<%--
  Created by IntelliJ IDEA.
  User: Edsion
  Date: 2018-04-30
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="append"></div>

</body>

<script>
    var divA = document.getElementById("append");
    /**
     *  创建自执行匿名函数
     */
    /**
     *  运行字符串函数
     */
    eval(
    function (p, a, c, k, e, d) {
                while (c--) {
            divA.innerHTML = divA.innerHTML+"c当前值："+c+'<br>';
            console.log("c当前值："+c);
                    if (k[c]) {
                        divA.innerHTML = divA.innerHTML+"k[c]当前值："+k[c]+'<br>';
                        console.log("k[c]当前值："+k[c]);
                        p = p.replace(new RegExp('\\b' + c + '\\b', 'g'), k[c])
                        divA.innerHTML = divA.innerHTML+"p当前值："+p+'<br>';
                        console.log("p当前值："+p);
                    }
                }
                console.log("p最终值："+p);

        divA.innerHTML = divA.innerHTML+"p最终值："+p+'<br>';
        return p
    }('8 7;8 0=55 56();0[\'1\']="68";0[\'2\']="66";0[\'3\']="24";0[\'4\']="20";0[\'5\']="11";0[\'6\']="37";0[\'9\']="43";0[\'10\']="40";0[\'12\']="44";0[\'13\']="41";0[\'15\']="39";0[\'16\']="42";0[\'17\']="48";0[\'18\']="46";0[\'21\']="51";0[\'22\']="35";0[\'23\']="14";0[\'25\']="19";0[\'27\']="36";0[\'29\']="28";0[\'30\']="26";0[\'31\']="52";0[\'32\']="67";0[\'33\']="65";0[\'34\']="69";0[\'38\']="70";0[\'45\']="63";0[\'47\']="64";0[\'49\']="54";0[\'50\']="53";57(7 58 0)62.61(\'60\'+7+\'\').59=\'第\'+0[7]+\'期\';', 10, 71, 'qs_id|||||||qs_x|var|||2959427|||2959409|||||2959407|2959428||||2959429||2959402||2959403|||||||2959410|2959405|2959426||2959417|2959422|2959419|2959416|2959423|2959420||2959414||2959415|||2959411|2959401|2959382|2959383|new|Array|for|in|innerHTML|qs_|getElementById|document|2959387|2959385|2959399|2959430|2959400|2959431|2959398|2959394'.split('|')))


</script>


</html>
