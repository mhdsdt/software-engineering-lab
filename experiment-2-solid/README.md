به نام خدا

# آشنایی با اصول شئ‌گرایی (موسوم به اصول SOLID)

## اهداف
در این آزمایش هدف بر آن است که دانشجویان با به کارگیری اصول SOLID در یک پروژه‌ی عملی ساده آشنا شوند.

## نیازمندی‌ها
آشنایی اولیه با مفاهیم برنامه نویسی و طراحی شی‌گرا که دانشجویان قبلاً در درس برنامه‌سازی پیشرفته با آن آشنا شده‌اند.

## ابزارهای مورد استفاده
- یک Java IDE مانند IntelliJ IDEA و یا Eclipse به همراه jdk حداقل نسخه ۸

## منابع آموزشی
برای آشنایی با این اصول و آشنایی با منابع مناسب به [اینجا](https://github.com/ssc-public/Software-Engineering-Lab/blob/main/educational-resources/SOLID/README.md) مراجعه کنید.

## مقدمه
در این آزمایش شما خواهید آموخت که چگونه می‌توانید با به کارگیری اصول SOLID، نرم‌افزارهایی را بسازید که از نظر قابلیت نگهداری و بهبود، در وضعیت مطلوبی باشند و مدیریت تغییرات در آن‌ها به آسانی میسر باشد (شک نکنید که به کارگیری این اصول اساسی و بسیاری دیگر از اصول مهندسی نرم افزار، باعث تفاوت شما با سایر همکارانتان خواهد شد)

## بخش اول: توضیحاتی پیرامون برنامه‌ی داده شده
می‌توانید برنامه را از [اینجا](https://github.com/ssc-public/Software-Engineering-Lab/tree/main/base-projects/SOLID-Principles) بارگیری کنید.

### مفروضات مسئله
صورت آزمایش در درس افزار بارگزاری شده است و می‌توانید برای تحویل گزارش (با در نظر گرفتن ملاحظات گفته شده) از قالب های زیر استفاده کنید.

## بخش دوم: دستور آزمایش

### گام ۱: افزودن یک روش پیام رسانی دیگر

	تغییراتی را که در کد فعلی برنامه می‌دهید، در جدول زیر ثبت کنید و در نهایت تعداد کل تغییرات را اعلان کنید.
    - توجه: مواردی که به عنوان تغییرات باید اعلان شود شامل این موارد هستند:
      1. ساخت کلاس جدید
      2. افزودن تابع جدید به کلاس و یا واسط (برای توابع جدید صرفا اعلام تغییر کنید)
      3. هر خطوط پیاپی‌ای که در تابع main و برای افزودن یک قابلیت جدید اضافه می‌کنید. به عنوان مثال اگر سه خط را به منظور تشخیص نوع پیام اضافه می‌کنید، آن سه خط را در قالب یک تغییر اعلام کنید (البته جزییات آن را در ستون «شرحی کوتاه از تغییر» توضیح دهید).

<table dir="rtl">
  <thead>
    <tr>
      <th><strong>ردیف</strong></th>
      <th><strong>محل اعمال تغییرات (کلاس/واسط)</strong></th>
      <th><strong>عنوان تغییر</strong></th>
      <th><strong>شرحی کوتاه از تغییر</strong></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>۱</td>
      <td><code>OrderService</code></td>
      <td>افزودن تابع پرداخت تلفنی</td>
      <td>افزودن یک تابع void با عنوان <code>phoneOrderPayment</code></td>
    </tr>
    <tr>
      <td>۲</td>
      <td><code>OrderService</code></td>
      <td>افزودن تابع ثبت سفارش تلفنی</td>
      <td>افزودن یک تابع void با عنوان <code>phoneOrderRegister</code></td>
    </tr>
    <tr>
      <td>۳</td>
      <td><code>PhoneOrderService</code></td>
      <td>ساخت کلاس جدید</td>
      <td>پیاده‌سازی واسط <code>OrderService</code></td>
    </tr>
    <tr>
      <td>۴</td>
      <td><code>PhoneOrderService</code></td>
      <td>پیاده‌سازی توابع جدید</td>
      <td>پیاده‌سازی توابع <code>phoneOrderRegister</code> و <code>phoneOrderPayment</code> در کلاس <code>PhoneOrderService</code></td>
    </tr>
    <tr>
      <td>۵</td>
      <td><code>OnSiteOrderService</code></td>
      <td>تغییر در کلاس <code>OnSiteOrderService</code></td>
      <td>افزودن توابع جدید <code>phoneOrderRegister</code> و <code>phoneOrderPayment</code> به کلاس</td>
    </tr>
    <tr>
      <td>۶</td>
      <td><code>OnlineOrderService</code></td>
      <td>تغییر در کلاس <code>OnlineOrderService</code></td>
      <td>افزودن توابع جدید <code>phoneOrderRegister</code> و <code>phoneOrderPayment</code> به کلاس</td>
    </tr>
    <tr>
      <td>۷</td>
      <td><code>Main</code></td>
      <td>افزودن قابلیت سفارش تلفنی</td>
      <td>اضافه کردن منطق برای سفارش و پرداخت تلفنی در تابع <code>main</code></td>
    </tr>
  </tbody>
</table>


مجموع تعداد تغییرات: ۷

### گام ۲: تحلیل و وارسی برنامه از منظر تحقق و یا عدم تحقق اصول SOLID
در خصوص این برنامه‌ای که نوشته شده بود و شما یک قابلیت به آن اضافه کردید، بر اساس اصول SOLID موارد نقض و یا محقق شدن هر کدام از آن اصول را بیان کنید. در بیان موارد تحقق و نقض، علت تحقق و یا نقض را نیز به صورت کامل توضیح دهید:

<table dir='rtl'>
<tbody>
<tr>
<td rowspan="2" width="240">
<p>اصل 1</p>
<p>Single Responsibility</p>
</td>
<td width="95">
<p><strong>موارد تحقق</strong></p>
</td>
<td width="454">
<p>- کلاس Food فقط مسئول نگهداری اطلاعات غذا است./</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>- کلاس Order دارای مسئولیت‌های مختلفی از جمله نگهداری اطلاعات سفارش، محاسبه قیمت کل و نمایش اطلاعات سفارش است. همچنین کلاس‌های OnSiteOrderService, OnlineOrderService, و PhoneOrderService دارای توابعی با بدنه خالی هستند.</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 2</p>
<p>Open-Close Principle (OCP)</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
<p>- استفاده از واسط‌ها برای پرداخت و ثبت سفارش. (کلاس‌های OnSiteOrderService, OnlineOrderService, و PhoneOrderService می‌توانند با افزودن متدهای جدید توسعه یابند.)</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>- کلاس Main برای افزودن روش‌های جدید پرداخت و سفارش نیاز به تغییر دارد.</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 3</p>
<p>Liskov Substitution Principle</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
<p>- کلاس‌های OnlineOrderService، OnSiteOrderService و PhoneOrderService می‌توانند جایگزین واسط‌های خود شوند بدون تغییر در رفتار. (تمامی کلاس‌هایی که از واسط OrderService پیروی می‌کنند، از توابع مورد نیاز خود استفاده می‌کنند.)</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>- روش‌های پیاده‌سازی شده در کلاس‌های مختلف ممکن است نیاز به تغییر در کلاس Main داشته باشند. همچنین کلاس‌های OnSiteOrderService, OnlineOrderService, و PhoneOrderService دارای توابعی با بدنه خالی هستند.</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 4</p>
<p>Interface Segregation Principle</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
<p>- استفاده از واسط‌های جداگانه برای ثبت سفارش و پرداخت.</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>- همه‌ی روش‌های پرداخت و سفارش در یک واسط کلی OrderService قرار دارند. و واسط OrderService شامل توابعی است که برخی از کلاس‌ها به تمامی آن‌ها نیاز ندارند.</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 5</p>
<p>Dependency Inversion Principle</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
<p>- وابستگی کلاس Main به واسط‌های OrderRegistrationService و OrderPaymentService به جای کلاس‌های پیاده‌سازی خاص.</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>- وابستگی مستقیم کلاس Main به کلاس‌های پیاده‌سازی خاص برای پرداخت و ثبت سفارش. بصورتی که کلاس Main مستقیماً نمونه‌هایی از کلاس‌های OnlineOrderService, OnSiteOrderService, و PhoneOrderService را ایجاد می‌کند.</p>
</td>
</tr>
</tbody>
</table>

در خصوص هرکدام از موارد نقض هرکدام از اصول، یک راهکار را به منظور رفع آن مشکل ارایه داده و در جدول زیر ثبت نمایید:

<table dir='rtl'>
<tbody>
<tr>
<td width="168">
<p><strong>اصل مربوطه (از اصول </strong><strong>SOLID</strong><strong>)</strong></p>
</td>
<td width="246">
<p><strong>علت نقض</strong></p>
</td>
<td width="284">
<p><strong>راه حل پیشنهادی</strong></p>
</td>
</tr>
<tr>
<td width="168">
<p>Single Responsibility Principle (SRP)</p>
</td>
<td width="246">
<p>کلاس Order دارای مسئولیت‌های مختلفی است.</p>
</td>
<td width="284">
<p>ایجاد کلاس OrderPrinter برای مسئولیت نمایش اطلاعات سفارش و جدا کردن محاسبه قیمت کل از کلاس Order.</p>
</td>
</tr>
<tr>
<td width="168">
<p>Open-Close Principle (OCP)</p>
</td>
<td width="246">
<p>کلاس Main برای افزودن روش‌های جدید پرداخت و سفارش نیاز به تغییر دارد.</p>
</td>
<td width="284">
<p>استفاده از واسط‌های جداگانه برای هر روش پرداخت و سفارش و پیاده‌سازی کلاس‌های مربوطه که از این واسط‌ها استفاده می‌کنند.</p>
</td>
</tr>
<tr>
<td width="168">
<p>Liskov Substitution Principle (LSP)</p>
</td>
<td width="246">
<p>اسط OrderService شامل توابعی بود که کلاس‌های پیاده‌سازی به همه آن‌ها نیاز نداشتند.</p>
</td>
<td width="284">
<p>تقسیم واسط به چند واسط کوچکتر تا هر کلاس فقط توابع مورد نیاز خود را پیاده‌سازی کند.</p>
</td>
</tr>
<tr>
<td width="168">
<p>Interface Segregation Principle (ISP)</p>
</td>
<td width="246">
<p>واسط OrderService شامل تمامی روش‌های پرداخت و سفارش است که باعث پیچیدگی و عدم استفاده مناسب می‌شود.</p>
</td>
<td width="284">
<p>استفاده از واسط‌های جداگانه برای هر روش پرداخت و ثبت سفارش، مثلاً OrderRegistrationService و OrderPaymentService.</p>
</td>
</tr>
<tr>
<td width="168">
<p>Dependency Inversion Principle (DIP)</p>
</td>
<td width="246">
<p>وابستگی مستقیم کلاس Main به کلاس‌های پیاده‌سازی خاص برای پرداخت و ثبت سفارش.</p>
</td>
<td width="284">
<p>استفاده از واسط‌های OrderRegistrationService و OrderPaymentService در کلاس Main به جای کلاس‌های پیاده‌سازی خاص.</p>
</td>
</tr>
</tbody>
</table>

### گام ۳: اصلاح موارد نقض
در نهایت، بر اساس تحلیلی که انجام داده‌اید و راه حل‌هایی که در بخش قبل ارایه کردید، کد را اصلاح کرده و بر روی مخزن گیت‌هاب و در پوشه‌ای مجزا از گام قبل commit و push کنید. انتظار می‌رود که تمامی راه حل‌های پیشنهادی خود را بر روی این نسخه اعمال کنید و تمامی بهبودهایی که انجام می‌دهید، در جداول بخش قبل موجود باشد.

### گام ۴: بررسی مجدد تغییرات مورد نیاز
فرض کنید که گام 1 را برای کد اصلاح شده (پس از انجام گام‌های ۲ و ۳) اجرا کرده‌اید.
1. در این صورت از انجام کدام یک از تغییرات ثبت شده در جدول گام ۱ معاف خواهید شد؟
2. تعداد تغییرات مورد نیاز، چند تغییر خواهد شد؟

### گام ۵: جمع بندی
در این بخش، بیان کنید که از این گام چه نتیجه‌ای گرفته‌اید؟ و به نظر شما به کارگیری صحیح اصول SOLID در گام‌های ۳ و ۴ چه مزایایی را نسبت به حالتی دارد که این اصول رعایت نشده‌بود؟

## نحوه ارسال پروژه:
1.	گام ۱ را انجام داده و سپس کد نوشته شده‌ی خود را (با رعایت محدودیت‌های گفته شده در گام) در یک پوشه به نام Step_1_Non_SOLID ذخیره کنید و در مخزن گام ۲ قرار دهید. موارد توضیحی بایستی در بخش README مخزن قرار گیرد.
2.	گام ۲ (که بخش تحلیلی است) در فایل README مربوط به مخزن گام ۲ آورده شود (تمام جداول با فرمت داده شده و عناوین هرکدام از سوالات پرسیده شده بایستی در README آورده شود).
3.	گام ۳ که شامل بهبود است، بایستی به صورت جداگانه در پوشه دیگری به نام Step_3_With_SOLID قرار داده شود و در مخزن موجود باشد.
4.	گام ۴ نیز در قالب توضیحات در README مخزن آورده شود.
5.	گام ۵ (که نتیجه گیری است) در README مخزن آورده شود.
