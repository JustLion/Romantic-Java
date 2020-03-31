### 1、 工作原理
1. 用户向服务器发送请求，请求被`SpringMVC`前端控制器`DispatchServlet`捕获。
2. `DispatchServlet`对请求`URL`进行解析，得到请求资源标识符（`URL`），然后根据该`URL`调用`HandlerMapping`将请求映射到`HandlerExecutionChain`
3. `DispatchServlet`根据获得`Handler`选择一个合适的`HandlerAdapter`适配器处理
4. `Handler`对数据处理完成以后将返回一个`ModelAndView()`对象给`DispatchServlet`
5. `Handler`返回的`ModelAndView()`只是一个逻辑视图并不是一个正式的视图，`DispatcherSevlet`通过`ViewResolver`试图解析器将逻辑视图转化为真正的视图`View`
6. `DispatcherServlet`通过`model`解析出`ModelAndView()`中的参数进行解析最终展现出完整的`view`并返回给客户端
### 2、 SpringMVC 常用的注解有哪些
1. @RequestMapping
2. @RequestBody
3. @ResponseBody
### 3、 如何解决 get 和 post 乱码问题
1. post 乱码：在 web.xml 里配置一个 CharacterEncodingFilter 过滤器，设置为utf-8
2. get 乱码：
    1. 修改 tomcat 配置文件添加编码和工程编码一致
    2. 对参数进行重新编码 `String userName =new String(request.getParameter("userName").getBytes("ISO8859-1"),"utf-8");`
### 4、 如何开启注解处理器和适配器
在 springmvc.xml 中通过开启 `<mvc:annotation-driven>` 来实现注解处理器和适配器的开启