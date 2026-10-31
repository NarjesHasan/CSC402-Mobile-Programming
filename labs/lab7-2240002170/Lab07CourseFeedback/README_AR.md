# Lab 7 — Task 2 + Task 3 (جاهز للتشغيل)

هذا المشروع يطبّق المطلوب من ملف CSC402_Lab7_Exercises.html:
- Task 2: StarRating باستخدام AndroidView وRatingBar، `factory` و`update`، شرط `fromUser`، شاشة Stateless وRoute تستخدم `rememberSaveable`، وزر Reset.
- Task 3: إذن INTERNET، CampusWebPage باستخدام WebView وWebViewClient و`loadUrl(url)` داخل `factory`، وCampusNewsScreen/Route.
- MainActivity فيها زران للتبديل بين التقييم والأخبار حتى تختبر التاسكين بسهولة، مع Activity واحدة فقط.
- Logcat: سجلات `Lab07` مضافة في factory وupdate لتجربة 2.5.

## فتح المشروع
1. فك ضغط ZIP كاملًا.
2. في Android Studio اختر **File → Open…** وحدد المجلد الرئيسي `Lab07CourseFeedback_Task2_Task3` (الذي يحتوي `settings.gradle.kts`). لا تفتح `app` ولا ملف HTML.
3. عند أول Sync يجب توفر اتصال لتنزيل Android Gradle Plugin ومكتبات Compose. اختر **Gradle JDK = JDK 21** إذا ظهرت نافذة JDK.
4. لأن اتصال services.gradle.org كان ينقطع، افتح **Android Studio → Settings → Build, Execution, Deployment → Build Tools → Gradle**. في **Gradle distribution** اختر **Local installation** ثم حدّد مجلد Gradle الذي فككت ضغطه: `gradle-8.11.1` (المجلد الذي يحتوي `bin` و`lib`، وليس ملف ZIP). ثم Apply/OK واضغط Sync Now.
5. إذا سألك Android Studio عن SDK 35، وافق على تنزيله/تثبيته. هذه المكونات قد تحتاج الإنترنت؛ لا يمكن ضمان تشغيل Android Studio لأول مرة بالكامل دون تنزيلها.
6. افتح **Tools → Device Manager**، شغّل محاكي Android، ثم اضغط زر **Run ▶** مع اختيار `app`.

## اختبار Task 2
- اضغط النجمة الرابعة ثم Reset؛ يجب أن يرجع كل من النجوم والنص إلى 0.
- افتح Logcat واكتب `Lab07` في الفلتر. اضغط قيم نجوم مختلفة ولاحظ `factory` و`update`.
- في `StarRating.kt`، جرّب مؤقتًا حذف `view.rating = stars` من `update` لملاحظة عدم تزامن النص والنجوم، ثم أعد السطر.
- `fromUser` يمنع التغييرات البرمجية القادمة من `update` من أن تُرسل كأنها حدث من المستخدم.
- جرّب تدوير المحاكي؛ `rememberSaveable` يحافظ على التقييم.

## اختبار Task 3
- اضغط **Campus News**؛ يجب أن تفتح صفحة جامعة الإمام داخل WebView.
- زر **Back** يرجعك للتقييم. زر **Course Rating** يرجع للتقييم أيضًا.
- `webViewClient = WebViewClient()` يبقي الروابط داخل WebView. إذن INTERNET موجود في AndroidManifest.xml.

تم بناء المشروع وتشغيله على محاكي Android Studio. توجد لقطات تشغيل التقييم والأخبار والتنقل في `submission-evidence/lab07/` على مستوى المستودع. سجلات `Lab07` الملتقطة من المحاكي محفوظة في `submission-evidence/lab07/lab07_rating_logcat.txt`.
