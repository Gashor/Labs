<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        <form method="post" action="/calculate">
            <div>
                <label about="x">X:</label>
                <input type="text" name="x"/>
                <label about="y">Y:</label>
                <input type="text" name="y"/>
            </div>
            <br/>
            <div>
                <input type="submit" name="operation" value="+"/>
                <input type="submit" name="operation" value="-"/>
                <input type="submit" name="operation" value="/"/>
                <input type="submit" name="operation" value="*"/>
            </div>
            <br/>
            <h2>${x} ${operation} ${y} = ${result}</h2>
        </form>
    </body>
</html>