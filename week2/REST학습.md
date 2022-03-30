
## REST(Representational State Transfer)

- Rest란 자원을 이름으로 구분하여 해당 자원의 상태를 주고 받는 모든 것을 의미한다.
- 자원(resource)으로만 표현(representation)하여 상태(state)를 전달(transfer)하는 것을 의미한다.
- REST는 ROA(Resource Oriented Architecture)를 따르는 웹서비스 아키텍쳐.
- 구체적으로 HTTP URL(Uniform Resource Identifier)를 통해 자원을 명시하고 HTTP Method(Post, Get, PUT, DELETE)를 통해 해당 자원에 대한 CRUD Operation을 적용하는 것
- CRUD는 대부분의 컴퓨터 소프트웨어가 가지는 기본적인 데이터 처리 기능인 **Create(생성)-(POST), Read(읽기)-(GET), Update(갱신)-(PUT), Delete(삭제)-(DELETE)**
를 묶어서 일컫는 말이다. 사용자 인터페이스가 갖추어야 할 기능(정보의 참조/검색/갱신)을 가리키는 용어로서도 사용된다.

## REST 장점

- HTTP를 활용하여, 별도 인프라 구축이 필요 없음.
- HTTP 표준 프로토콜에 따르는 모든 플랫폼에서 사용가능
- REST API에 메시지가 의도하는바를 명확하게 나타내어 의도파악이 쉽다.
- 여러가지 서비스 디자인에서 생길 수 있는 문제를 최소화한다.
- 서버와 클라이언트의 역할을 명확하게 분리한다. (서버- 클라이언트 구조를 띄우기 때문)

## REST단점

- 표준이 존재하지 않는다.
- 사용 할 수 있는 메소드가 제한적임(4개).
- 구형 브라우저가 아직 제대로 지원못함.

⇒그럼에도 REST가 필요한 이유는 애플리케이션의 분리 및 통합, 다양한 클라이언트의 등장, 서버의 다양화, 다양한 브라우저가 존재하기 때문이다,멀티 플랫폼에대한 지원
 
 # HTTP란?

⇒ **HTTP** (**H**yper**T**ext **T**ransfer **P**rotocol)

HTTP는 [클라이언트](https://ko.wikipedia.org/wiki/%ED%81%B4%EB%9D%BC%EC%9D%B4%EC%96%B8%ED%8A%B8)와 [서버](https://ko.wikipedia.org/wiki/%EC%84%9C%EB%B2%84) 사이에 이루어지는 요청/응답(request/response) 프로토콜이다.

**클라이언트**

서버에게 요청을 보내는 리소스 사용자 ex) 웹 브라우저, 모바일 애플리케이션, IoT 등

**서버**

클라이언트에게 요청에 대한 응답을 제공하는 리소스 관리자

HTTP를 통해 전달되는 자료는 http:로 시작하는 [URL](https://ko.wikipedia.org/wiki/URL)(인터넷 주소)로 조회할 수 있다.

- HTTP 메소드

ex) GET,HEAD, POST, PUT, DELETE, CONNECT, OPTIONS, TRACE, PATCH 

# 브라우저에 URL을 입력 후 요청하여 서버에서 응답하는 과정

크게보면 

1. 브라우저가 URL의 **IP 주소**를 찾기 위해 **캐시**에서 **DNS 기록**을 확인한다.
2. 만약 요청한 URL이 캐시에 없다면, I**SP(internet service provider)의 DNS(Domain name server) 서버**가 **DNS 쿼리로** URL을 **호스팅**하는 서버의 IP 주소를 찾는다.
3. 브라우저가 해당 서버와 **TCP 연결**을 시작한다.
4. 브라우저가 웹서버에 **HTTP 요청**을 보낸다.
5. 서버가 요청을 처리하고 **응답**을 보낸다.

++ 네트워크 과정 

**1. 브라우저의 URL 파싱**

- **어떤 프로토콜을 통해 해당 URL에 요청할 것인지**
- **어떤 URL로 요청할 것인지**
- **어떤 포트로 요청할 것인지**

브라우저에서 각각 프로토콜, URL, 포트를 해석하여 분석합니다. ex) [https://naver.com:406](https://naver.com:406) 

**포트**를 선언하지 않았다면 브라우저에서는 설정된 기본값을 이용해 요청. HTTP라면 80 포트를, HTTPS라면 443 포트를 기본 값으로 요청.

**2.HSTS(HTTP Strict transport security)목록 조회**

- HTTP를 허용하지 않고 HTTPS를 사용하는 연결만 허용하는 기능.(WHY?)
- 요청이 왔을 때, HTTP 응답 헤더에 "Strict Transport Security"라는 필드를 포함하여 응답하고 이를 확인한 브라우저는 해당 서버에 요청할 때 HTTPS만을 통해 통신한다. 그리고 자신의 HSTS캐시에 해당 URL을 저장하는데 이를 HSTS 목록이라고 부릅니다.

**3. URL을 IP주소로 변환**

- 캐시에 해당 URL이 존재하는지 확인한다. 존재하지 않는다면 도메인 주소를 IP주소로 변환해주는 DNS(Domain Name System) 서버에 요청하여 해당 URL을 IP주소로 변환합니다.
- **DNS Lookup**
 이란 DNS 서버에서 인터넷 도메인 이름을 사용해 인터넷 주소 (ip)를 알아내는 과정이다. 상위계층에서 하위계층까지 탐색함.

**4. 라우터를 통해 해당 서버의 게이트웨이까지 이동**

- 알아낸 IP주소를 라우팅을 통해 서버의 게이트웨이까지 이동.

**5. ARP를 통해 IP주소를 MAC주소로 변환**

**6. 대상 서버와 TCP 소켓 연결**

- HTTP 요청에서는 **TCP(Transmission Control Protocol)** 라는 **전송 제어 프로토콜**을 사용한다.
- 3-way-handshake 과정을 통해 소켓연결
1. 클라이언트는 인터넷을 통해 서버에 **SYN 패킷**을 보내 새 연결이 가능한지 여부를 묻는다.
2. 서버에 새 연결을 수락할 수 있는 열린 포트가 있는 경우, **SYN/ACK 패킷**을 사용하여 SYN 패킷의 ACK(승인)으로 응답한다.
3. 클라이언트는 서버로부터 SYN/ACK 패킷을 수신하고 **ACK 패킷**을 전송하여 승인한다.

**7. HTTP(HTTPS) 프로토콜로 요청, 응답**

- 서버는 이 요청에 대한 응답을 작성해 브라우저에게 전달.

**8. 브라우저에서 응답을 해석**
