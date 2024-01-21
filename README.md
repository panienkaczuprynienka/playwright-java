# playwright-java


## Table of Contents

- [Useful](#useful)
- [Features](#features)
- [Prerequisites](#prerequisites)


## Useful

Start test generating

```bash
mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen demo.playwright.dev/todomvc"
```

Open zip file
```bash
mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace trace.zip"
```