# روش ایجاد مبتنی بر رفتار

## روال انجام آزمایش
### ۱. مراحل عملی Example

- ابتدا پروژه را به صورت یک ماژول جدید در پوشه `experiment-4-bdd` ایجاد می‌کنیم.
![img.png](images/img.png)

- سپس dependecyهای گفته شده را به فایل `pom.xml` اضافه می‌کنیم.
![img_1.png](images/img_1.png)

- سپس Test lifecycle را از maven toolbar اجرا می‌کنیم.
![img_2.png](images/img_2.png)

- در این اسکرین‌شات می‌توانیم مشاهده کنیم dependencyها با موفقیت اضافه شده‌اند
![img_3.png](images/img_3.png)

- حال یک پوشه به نام resources در پوشه test ایجاد می‌کنیم و آن را Mark directory as -> Test Resources Root تغییر می‌دهیم.
![img_4.png](images/img_4.png)

- حال پکیج calculator در پوشه main/java ایجاد می‌کنیم و یک کلاس به نام Calculator.java در آن ایجاد می‌کنیم.
![img_5.png](images/img_5.png)

- حال پوشه‌های به اسم features در پوشه test/resources ایجاد می‌کنیم.
![img_6.png](images/img_6.png)

- حال یک فایل به نام calculator.feature در پوشه test/resources/features ایجاد می‌کنیم.
![img_7.png](images/img_7.png)
پلاگین Gherkin را نیز نصب می‌کنیم:
![img_8.png](images/img_8.png)

- سپس به کمک Alt + Enter می‌توانیم stepها را به صورت خودکار ایجاد کنیم.
![img_9.png](images/img_9.png)
![img_10.png](images/img_10.png)

- سپس فایل ایجاد شده را با توجه به دستورکار کامل می‌کنیم.
![img_11.png](images/img_11.png)

- حال بار دیگر Test lifecycle را اجرا می‌کنیم.
![img_12.png](images/img_12.png)

- حال calculator.feature را اجرا می‌کنیم.
![img_13.png](images/img_13.png)
پس از اجرا مشاهده می‌کنیم که با همچین خطایی مواجه می‌شویم.
![img_14.png](images/img_14.png)

- برای رفع این خطا، به فایل `pom.xml` می‌رویم و به جای استفاده از info.cukes از io.cucumber را استفاده می‌کنیم.
![img_15.png](images/img_15.png)
سپس با این خطا مواجه می‌شویم:
![img_16.png](images/img_16.png)
کانفیگ اجرای calculator.feature را به صورت زیر تغییر می‌دهیم:
![img_17.png](images/img_17.png)

- سپس دوباره calculator.feature را اجرا می‌کنیم.
![img_18.png](images/img_18.png)
مشاهده می‌کنیم که سناریوها با موفقیت اجرا شده‌اند.

- حالا کلاس RunnerTest.java را در کنار MyStepdefs.java اضافه می‌کنیم.
![img_19.png](images/img_19.png)
همانطور که می‌بینیم به خطایی که در عکس بالا آمده است برمی‌خوریم. برای رفع آن از @CucumberOptions استفاده می‌کنیم:
![img_20.png](images/img_20.png)

- با عوض کردن مقادیر موجود در calculator.feature می‌توانیم ببینیم تست‌ها به درستی در حال اجرا هستند.
![img_21.png](images/img_21.png)

- حال Scenario Outline را به فایل calculator.feature اضافه می‌کنیم.
![img_22.png](images/img_22.png)
همانطور که می‌توانیم ببینیم با خطای undefined مواجه می‌شویم.

### ۲. رفع خطای undefined
- با کمی بررسی متوجه می‌شویم که matcherای که در MyStepdefs.java تعریف کرده‌ایم اعداد منفی را match نمی‌کند.
```java
@Given("^Two input values, (\\d+) and (\\d+)$")
public void twoInputValuesAnd(int arg0, int arg1) {
    value1 = arg0;
    value2 = arg1;
}
```

حال کد را به شکل زیر تغییر می‌دهیم تا اعداد منفی را نیز match کند.
```java
@Given("^Two input values, (-?\\d+) and (-?\\d+)$")
public void twoInputValuesAnd(int arg0, int arg1) {
    value1 = arg0;
    value2 = arg1;
}
```

سپس دوباره اجرا می‌کنیم و مشاهده می‌کنیم که تست‌ها پاس می‌شوند:
![img_23.png](images/img_23.png)