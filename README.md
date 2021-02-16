
# Art # - 무명작가 플랫폼 앱

# 프로젝트 개요

![1](https://user-images.githubusercontent.com/63458653/87631277-01494680-c772-11ea-897f-5ea7415efb15.png)

현재 그림 작가들은 그림 커뮤니티를 이용해서 자신의 이름과 작품을 알린다.

기존의 그림 커뮤니티 앱은 원하는 사용자의 작품을 좋아요(추천)으로 평가하고 추천순으로 상단에 위치된다. 

그래서 사용자들이 함께 행동하며 작품과 관계없이 추천을 주고 받는 이른바 '친목'이 존재한다.

본 애플리케이션은 무작위의 작품을 점수제로 평가해서 사용자가 작품을 인맥이 아닌 실력으로 평가받도록 한다.

또한 사용자가 메신저를 통해 의견을 주고받거나 스카우트 제의, 작품 의뢰 등을 할 수 있고 사용자가 그린 작품의 연계상품(굿즈)를 판매할 수 있다. 

이를 통해 사용자가 자신의 작품이 얼마나 공감을 부를 수 있는지 객관적으로 판단할 수 있게 되고 사용자가 실력만으로도 스펙을 쌓고 수익을 창출해 낼 수 있게 되는 것이  우리의 최종 목표이다.
<br><br>
- 서비스: 무명작가 플랫폼 애플리케이션
- 개발 환경: Android Studio 3.6
- 개발 언어: Java, XML
- 기타 환경: Git 
- 외부 자원: AWS EC2 Instance
- 관련 기술: Flask, PyMySQL, Retrofit, Ubuntu, Restful API Server
- 제약 사항: 안드로이드 OS 4.0 이상, 인터넷 접속 권한

<br>



# 사용자 요구사항

1. 기능적 요구사항

   ![1](https://user-images.githubusercontent.com/63458653/87670459-b566c380-c7aa-11ea-8582-5fece6eb2dbf.PNG)
   
   ![2](https://user-images.githubusercontent.com/63458653/87670855-6a00e500-c7ab-11ea-9baf-d497bc1d417e.PNG)
 
   ![3](https://user-images.githubusercontent.com/63458653/87670867-6d946c00-c7ab-11ea-91d7-e0869dd0c19c.PNG)
 
   ![4](https://user-images.githubusercontent.com/63458653/87670876-7127f300-c7ab-11ea-924c-1a77d13de24e.PNG)
 
   ![5](https://user-images.githubusercontent.com/63458653/87670881-72f1b680-c7ab-11ea-9518-d41b3f8c59ad.PNG)
 
   ![6](https://user-images.githubusercontent.com/63458653/87670893-771dd400-c7ab-11ea-8200-326abc32d2b7.PNG)
 
   ![7](https://user-images.githubusercontent.com/63458653/87670906-7ab15b00-c7ab-11ea-8ae5-245aaf28c834.PNG)
 
   ![8](https://user-images.githubusercontent.com/63458653/87670919-7e44e200-c7ab-11ea-97ba-3116b53b16af.PNG)
 
   ![9](https://user-images.githubusercontent.com/63458653/87670931-813fd280-c7ab-11ea-8f4c-6db87cb7be9c.PNG)
 
   ![10](https://user-images.githubusercontent.com/63458653/87670940-83a22c80-c7ab-11ea-8cac-f96a6fa541d3.PNG)
<br><br><br><br>
2. 비기능적 요구사항

   ![1111](https://user-images.githubusercontent.com/63458653/87670948-8735b380-c7ab-11ea-8c99-88dd1afd154f.PNG)


<br>

# 화면 구성도

![image](https://user-images.githubusercontent.com/63458653/87671098-b815e880-c7ab-11ea-80b4-fd43f3a74f3c.png)


<br>


# Application 

## 메인

![mainwork](https://user-images.githubusercontent.com/63458653/87678571-134cd880-c7b6-11ea-9dc3-2f3de8c7b54f.jpg)
![mainwriter](https://user-images.githubusercontent.com/63458653/87679554-4ba0e680-c7b7-11ea-9984-7cc70a76408d.jpg)

1. 랜덤평가 버튼을 터치하면 무작위 작품 평가화면으로 이동한다.
2. 작품등록 버튼을 터치하면 작품 등록화면으로 이동한다.
3. 작품 탭을 터치하면 작품목록을 조회할 수 있다.
4. 작품목록 창을 스와이프하면 더 많은 작품목록을 조회할 수 있다.
5. 작품 이미지를 터치하면 작품 상세 조회 화면으로 이동한다.
6. 작가 탭을 터치하면 작가목록을 조회할 수 있다
7. 작가목록 창을 스와이프하면 더 많은 작가목록을 조회할 수 있다.
8. 작가 이미지를 터치하면 해당 작가의 페이지 화면으로 이동한다.
9. 왼쪽의 상단에 메뉴 바를 터치하면 개인 정보 관리와 고객센터 등 드롭다운이 나타나고 터치 시 해당 화면으로 이동한다.
10. 오른쪽의 상단에 사용자 아이콘을 터치하면 자신의 사용자 페이지 화면으로 이동한다.
11. 작품은 평가를 마친 작품 중 평균 점수가 높은 순부터 배치된다.
12. 작가는 평가를 마친 작품 수가 5점 이상인 작가부터 작품 평균 점수가 높은 순으로 배치된다.
13. 점수가 같을 경우에는 최신 순으로 배치된다.
14. 1,2,3 순위 작품, 작가는 점수 위젯에  특별한 속성을 부여한다.
15. 작품탭의 프래그먼트는 스태거드 그리드 레이아웃으로 가로를 레이아웃의 크기에 맞추고 세로를 조절한다.


<br>

## **작품 등록**

![insert](https://user-images.githubusercontent.com/63458653/87678560-121bab80-c7b6-11ea-8d43-44ed7b842ce7.jpg)

1. 화면 가운데 + 이미지를 터치하면 본인의 갤러리에서 작품을 불러올 수 있다.
2. 에디트 텍스트를 터치하면 사용자 작품의 작품명을 입력할 수 있다.
3. 왼쪽의 하단에 취소 버튼을 터치하면 이전 화면으로 이동한다.
4. 왼쪽의 상단에 < 아이콘을 터치하면 이전 화면으로 이동한다.
5. 오른쪽의 하단에 등록 버튼을 터치하면 작품이 등록된다.
6. 로고를 터치하면 사용자 메인화면으로 이동한다.
7. 작품명을 입력하지 않거나 이미지를 등록하지 않으면 에러메시지를 출력한다.

<br>

## **작품 평가**

![assess](https://user-images.githubusercontent.com/63458653/87678551-0fb95180-c7b6-11ea-9678-9e1e7e11382f.jpg)

1. 레이팅 바를 터치하면 변수에 해당 위치만큼 작품에 대한 사용자의 평가 점수가 저장된다.
2. 다음 평가>> 버튼을 누르면 저장된 점수로 평가가 완료되고 다음 작품 평가화면으로 이동한다.
3. 평가 마침 버튼을 누르면 정말 마칠지 묻는 대화상자가 나오고 확인을 누르면 저장된 점수로 평가가 완료되고 사용자 메인화면으로 이동한다.
4. 작품 이미지를 터치하면 이미지가 확대되고 핀치줌을 사용할 수 있다.
5. 왼쪽의 상단에 < 아이콘을 터치하면 사용자 메인화면으로 이동한다.
6. 오른쪽의 상단에 하트 아이콘을 터치하면 찜하기가 되고 내 페이지에서 다시 찾아볼 수 있게 된다.
7. 한 작품당 평가는 50회까지 진행되고 평가를 마쳐야 메인화면에 등록된다.
8. 평가를 시행하면 1포인트가 적립되며 상품을 구매할 때 1포인트당 1%할인을 50%까지 받을 수 있다.
9. 점수를 선택하지 않고 평가를 요청하면 에러메시지를 출력한다.
<br>

## **작품 상세 조회**

![load](https://user-images.githubusercontent.com/63458653/87678561-121bab80-c7b6-11ea-81aa-b67334281a7a.jpg)

1. 에디트 텍스트를 터치하면 해당 작품에 댓글을 입력할 수 있다.
2. 에디트 텍스트 우측 아이콘을 터치하면 입력한 댓글을 남길 수 있다.
3. 댓글 창을 스와이프하면 더 많은 댓글을 조회할 수 있다.
4. 사용자 아이콘을 터치하면 해당 사용자의 페이지로 이동한다.
5. 댓글 중 하나를 터치하면 그 댓글에 대한 답글을 남길 수 있다.
6. 작품 이미지를 터치하면 이미지가 확대되고 핀치줌을 사용할 수 있다.
7. 왼쪽의 상단에 < 버튼을 터치하면 이전 화면으로 이동한다.
8. 우측의 상단에 하트 아이콘을 터치하면 찜하기가 된다.
9. 로고를 터치하면 사용자 메인화면으로 이동한다.
10. 오른쪽의 상단에 하트 아이콘을 터치하면 찜하기가 되고 내 페이지에서 다시 찾아볼 수 있게 된다. 
11. 해당 작품의 작품명, 작가, 게시일, 평균 점수, 찜하기 수, 댓글, 댓글 게시일을 확인할 수 있다.
<br>

## **사용자 페이지**

![userpage](https://user-images.githubusercontent.com/63458653/87678579-147e0580-c7b6-11ea-9e62-fd68bfdbd5b2.jpg)

1. 프로필 이미지를 터치하면 사용자의 프로필 이미지를 수정할 수 있다.
2. 연필 아이콘을 터치하면 사용자의 자기소개를 등록 / 수정할 수 있다.
3. 작품 탭을 터치하면 사용자의 작품들을 관리할 수 있다.
4. 상품 탭을 터치하면 사용자의 상품들을 관리할 수 있다.
5. 하트 탭을 터치하면 사용자가 찜한 작품들을 관리할 수 있다.
6. 모든 게시글은 스와이프하면 더 많은 목록을 조회할 수 있다.
7. 팔로워 (팔로워 수)를 터치하면 사용자의 팔로워들을 관리할 수 있다.
8. 팔로잉 (팔로잉 수)를 터치하면 사용자의 팔로잉들을 관리할 수 있다.
9. 왼쪽의 상단에 < 아이콘을 터치하면 이전 화면으로 이동한다.
10. 오른쪽의 상단에 쪽지 아이콘을 터치하면 쪽지를 관리할 수 있다.
11. 로고를 터치하면 사용자 메인화면으로 이동한다.
<br>

##  Others
![messenger](https://user-images.githubusercontent.com/63458653/87682615-01b9ff80-c7bb-11ea-85a6-663a4c53c3fb.jpg)
![gain](https://user-images.githubusercontent.com/63458653/87678557-11831500-c7b6-11ea-94c0-6d857192a5c0.jpg)
![message](https://user-images.githubusercontent.com/63458653/87678574-13e56f00-c7b6-11ea-869a-6917c3aa36fe.jpg)
![qna](https://user-images.githubusercontent.com/63458653/87678577-147e0580-c7b6-11ea-977a-b998f8b7bf5a.jpg)


