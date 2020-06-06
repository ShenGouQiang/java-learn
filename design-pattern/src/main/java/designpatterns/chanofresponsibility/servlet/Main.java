package designpatterns.chanofresponsibility.servlet;

public class Main {
    public static void main(String[] args) {
        Request request = new Request();
        request.setRequestStr("<script>Hello,:). 996, welcome to back</script>");
        Response response = new Response();
        response.setResponseStr(" response ");
        FilterChain chain = new FilterChain();
        chain.add(new FaceFilter());
        chain.add(new WorkFilter());
        chain.add(new ScriptFilter());
        chain.chain(request,response);
        System.out.println(request);
        System.out.println(response);
    }
}
