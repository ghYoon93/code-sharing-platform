<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Latest</title>
</head>
<body>
    <#list codes as code>
        <div>
            <span id="load_date">${code.date}</span>
            <pre id="code_snippet">${code.code}</pre>
        </div>
    </#list>
</body>
</html>