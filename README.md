# KotlinBasic
코틀린 기초 코드 연습

안드로이드 생존코딩 Kotlin 편 

필요한 부분은 수정해서 작성하였습니다.

==========================================================

BMI 계산기

기존 책의 내용 : Intent를 이용한 페이지 전환 및 인자 주고 받기

사용한 내용 : activity가 아닌 fragment로 구성 navigation을 이용한 페이지 전환 및 인자 주고 받기

popUpTo는 BackStack에서 어디까지 이동할 것인지 결정하는 속성

popUpToInclusive는 popUpTo로 지정한 fragment까지 pop 시킬 것인지 정하는 속성

==========================================================

LabTime

기존 책의 내용 : Scrollview를 이용한 랩 작성, rundOnUiThread

사용한 내용 : Recyclerview를 이용

Recyclerview의 구성 요소

Adpater

onCreateViewHolder

onBindViewHolder

getItemCount

viewholder

valueObject 

==========================================================

WebView

기존 책의 내용 : anko 라이브러리를 이용한 공유하기 및 기본 웹 브라우저로 열기

사용한 내용 : splitties를 이용한 웹브라우저 열기

anko에서 지원하던 기능을 사실상 splitties에서 거의 다 지원한다고 보면 된다.

menu에 대해 공부

웹뷰에서의 뒤로가기 onBackPressed() 재정의해서 사용

옵션메뉴와 컨텍스트메뉴 사용한다

WebView를 사용할때 WebViewClient를 사용한다.

자주 사용하는 메소드

shouldOverrideUrlLoading

주로 새 창을 열 때 분기로 많이 쓴 듯함..

내가 주로 썼던 곳은 결제부문이나 본인인증 할 때 썼었다.

웹뷰에서의 자바스크립트를 연동

addJavascriptInterface

==========================================================