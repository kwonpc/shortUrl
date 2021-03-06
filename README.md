Url Shortening
==============

URL을 입력받아 짧게 줄여주고, Shortening된 URL을 입력하면 원래 URL로 리다이렉트하는 URL Shortening Service
예) https://en.wikipedia.org/wiki/URL_shortening => http://localhost/JZfOQNro

## 요구사항

- webapp으로 개발하고 URL 입력폼 제공 및 결과 출력
- URL Shortening Key는 8 Character 이내로 생성되어야 합니다. 
- 동일한 URL에 대한 요청은 동일한 Shortening Key로 응답해야 합니다. 
- Shortening된 URL을 요청받으면 원래 URL로 리다이렉트 합니다. 
- Shortening Key 생성 알고리즘은 직접 구현해야 합니다. (라이브러리 사용 불가)
- Database 사용은 필수 아님 (선택)
 
- README.md 파일에 프로젝트 소개 및 문제해결 전략 그리고 프로젝트 빌드와 실행 방법 명시 
- Unit Test 코드 작성
- 언어, 프레임워크의 제한 없음
## 문제해결

### 페이지 구성
- home 역할을 하면서 URL 입력폼 페이지 
- Shortening된 URL을 요청받으면 원래의 URL로 리다이렉트시키는 RESTFUL API 구성
- URL을 입력받으면 유니크한 Shortening Key를 생성하여 사용자에게 보여주는 페이지

### Shortening Key 생성 알고리즘
- Key가 너무 길어지므로 URL을 통째로 Encoding이나 Encrypt 할 수는 없다
- 일정 길이 제한의 유니크한 시퀀스를 ASCII 코드같은 문자열로 변환할 수 있다면 짧은 Character 생성이 가능할 것
- ASCII 코드에서 주소창에서 무리없이 쓸 수 있는 문자 형태 [A-Z][a-z][0-9] 를 골라 62진법을 만든다
- URL과 맵핑한 유니크한 시퀀스를 62진법으로 변환하여 Shortening Key를 생성한다
- 8자리의 Key를 사용가능하다 했을때 이론상 218,340,105,584,896 개의 단축 URL생성이 가능해진다

### 일정 길이의 Shortening Key생성
- DB의 시퀀스를 이용하여 key생성을 하다 보니 초기에는 한자리수 등의 짧은 URL이 나온다
- 상관은 없지만 일관성 및 보기에도 좋게 하기 위해 일정 자릿수를 충족하게끔 구성한다
- yyMMdd * 100,000,000 + SeqNo 로 Key 변환을 할시 항상 8자리 숫자를 충족한다

## 프로젝트 빌드 및 실행 방법

### 필요 환경
- JAVA 1.8
- Eclipse Java EE IDE for Web Developers Mars 이상
- Apache Tomcat 8 이상
- MySQL 5 이상
 
#### mysql 셋팅
* mysql 설치 시 모든 옵션 기본 / 비밀번호 1234로 셋팅
* MySQL Command Line Client 를 실행하여 아래의 명령어로 데이터베이스와 테이블을 생성
<pre><code> 
mysql> create database shorturl;
Query OK, 1row affected (0.00 sec)

mysql> use shorturl;
Database changed

mysql> CREATE TABLE tb_short_url_data (
  SEQ_NO int(8) NOT NULL AUTO_INCREMENT,
  CONTEXT varchar(10) DEFAULT NULL,
  URL varchar(300) DEFAULT NULL,
  PRIMARY KEY (SEQ_NO),
  UNIQUE KEY SEQ_NO (SEQ_NO)
);
Query OK, 1row affected (0.02 sec)
</code></pre>

#### 이클립스 셋팅

<pre><code> 
Git Repositoires 에 https://github.com/kwonpc/shortUrl.git 등록 후 Import Projects 로 내려받기
내려받은 test2 프로젝트를 Maven 빌드 (goals:install) 
이클립스에 로컬 Tomcat 서버연동하여 프로젝트 실행 ( path: / 지정 )
브라우저에서 localhost:8080 으로 확인
</code></pre>



