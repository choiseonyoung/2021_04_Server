# Req And Res
* Request(요청), Response(응답)
* Run As / Run on Service로 실행하면
Tomcat이 작동되면서 현재 프로젝트를 Web으로 서비서를 하기 위해 시작된다.
001.Hello 와 같은 주소를 입력하고 Enter를 누르면
* losahost(내 컴퓨터)의 8080 Port에서 기다리고 있는 Tomcat에게 요청을 한다.
* tomcat은 /Service_0e1_Hello라는 문자열을 보고
현재 프로젝트 중에 Server_001.Hellog 라는 프로젝트가 Run되어 있는지를 찾는다.
* 있으면 프로젝트의 webapp 폴더에서 index.htm, index.html, index.jsp

* 없으면 404 파일없음, (fileNot found) 오류 메시질ㄹ 전송한다.

* localhost:8080\\Service_001_Hello 라고 