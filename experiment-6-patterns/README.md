# MiniJava
Mini-Java is a subset of Java. MiniJava compiler implement a compiler for the Mini-java
programming language.

# Rules of MiniJava
```
Goal --> Source EOF
Source --> ClassDeclarations MainClass
MainClass --> class Identifier { public static void main() { VarDeclarations Statements}}
ClassDeclarations --> ClassDeclaration ClassDeclarations | lambda
ClassDeclaration --> class Identifier Extension { FieldDeclarations MethodDeclarations }
Extension --> extends Identifier | lambda
FieldDeclarations --> FieldDeclaration FieldDeclarations | lambda
FieldDeclaration --> static Type Identifier ;
VarDeclarations --> VarDeclaration VarDeclarations | lambda
VarDeclaration --> Type Identifier ;
MethodDeclarations --> MethodDeclaration MethodDeclarations | lambda
MethodDeclaration --> public static Type Identifier ( Parameters ) { VarDeclarations Statements return GenExpression ; }
Parameters --> Type Identifier Parameter | lambda
Parameter --> , Type Identifier Parameter | lambda
Type --> boolean | int
Statements --> Statements Statement | lambda
Statement --> { Statements } | if ( GenExpression ) Statement else Statement | while ( GenExpression ) Statement | System.out.println ( GenExpression ) ; | Identifier = GenExpression ;
GenExpression --> Expression | RelExpression
Expression --> Expression + Term | Expression - Term | Term
Term --> Term * Factor | Factor
Factor --> ( Expression ) | Identifier | Identifier . Identifier | Identifier . Identifier ( Arguments ) | true | false | Integer
RelExpression --> RelExpression && RelTerm | RelTerm
RelTerm --> Expression == Expression | Expression < Expression
Arguments --> GenExpression Argument | lambda
Argument --> , GenExpression Argument | lambda
Identifier --> <IDENTIFIER_LITERAL>
Integer --> <INTEGER_LITERAL>
```

## فاز دوم
اهداف
سازماندهی ساختار فایل‌ها و نام‌گذاری‌ها:

ایجاد فایل‌ها و دایرکتوری‌های جداگانه برای پیاده‌سازی الگوهای طراحی Facade و Strategy.
به‌روز‌رسانی کلاس‌های موجود مانند SymbolTable، Address، و CodeGenerator.
بازسازی کلاس‌های موجود:

جدا کردن متدهای پرس‌وجو (Query) و اصلاح‌کننده (Modifier) در کلاس SymbolTable.
اعمال اصل Self Encapsulated Field در کلاس Address.
بازسازی کلاس CodeGenerator برای استفاده از الگوی Strategy برای عملیات‌های ریاضیاتی و حذف کدهای تکراری.
ایجاد یک Enum برای کلاس Operation جهت بهبود ایمنی نوعی (Type Safety).
جزئیات پیاده‌سازی هر بازسازی:

پیاده‌سازی الگوهای Facade برای ساده‌سازی تعاملات با زیرسیستم‌های پیچیده.
پیاده‌سازی الگوی Strategy برای اضافه کردن آسان پیاده‌سازی‌های جدید عملیات.
جدا کردن متدهای پرس‌وجو و اصلاح‌کننده در کلاس SymbolTable برای بهبود خوانایی کد و جلوگیری از تغییرات ناخواسته در وضعیت.
اعمال اصل Self Encapsulated Field برای کنترل بهتر و اعتبارسنجی دسترسی به فیلدها.
بازسازی کلاس CodeGenerator برای بهبود خوانایی، نگهداری‌پذیری، و ایمنی نوعی کد.

بازسازی‌های انجام‌شده بر روی پروژه MiniJava به‌طور چشم‌گیری ساختار، خوانایی، و نگهداری‌پذیری کد را بهبود بخشیده است. با اجرای الگوهای طراحی و رعایت اصول مهندسی نرم‌افزار، پروژه اکنون قابلیت ارتقاء و توسعه‌ی آسان‌تر و مؤثرتر را داراست. این تغییرات نه تنها به بهبود عملکرد فعلی کمک کرده، بلکه اساسی مستحکم برای توسعه‌های آتی فراهم آورده است.



## بخش سوالات

### 1. دسته‌بندی الگوهای طراحی در کتاب GoF

کتاب GoF (Gang of Four) سه دسته اصلی از الگوهای طراحی را معرفی کرده است:

- **الگوهای ایجاد (Creational Patterns)**: این الگوها بر نحوه ایجاد اشیاء تمرکز دارند و هدف آن‌ها فراهم کردن انعطاف‌پذیری در ایجاد و مدیریت اشیاء است. مثال‌هایی از این الگوها شامل Singleton و Factory Method می‌شود.
- **الگوهای ساختاری (Structural Patterns)**: این الگوها به چگونگی ترکیب و سازماندهی کلاس‌ها و اشیاء برای ایجاد ساختارهای بزرگ‌تر و پیچیده‌تر می‌پردازند. مثال‌هایی از این الگوها شامل Adapter و Composite است.
- **الگوهای رفتاری (Behavioral Patterns)**: این دسته الگوها به نحوه تعامل و ارتباط بین اشیاء می‌پردازند و مسئولیت‌ها را بین آن‌ها توزیع می‌کنند. مثال‌هایی از این الگوها شامل Observer و Strategy می‌شود.

### 2. الگوهای استفاده شده در فاز اول آزمایش

با توجه به ساختار پروژه و آنچه که در فاز اول پیاده‌سازی کردیم، به نظر می‌رسد الگوهای استفاده شده بیشتر مربوط به دسته الگوهای رفتاری (Behavioral Patterns) و ساختاری (Structural Patterns) باشند. به عنوان مثال، ممکن است از الگوی **Singleton** برای مدیریت دسترسی به منابع مشترک یا از الگوی **Observer** برای اطلاع‌رسانی تغییرات استفاده کرده باشیم.

### 3. انتخاب الگوی طراحی برای مدیریت درخواست‌ها

با توجه به اینکه در فاز اول پروژه درخواست‌ها به دو حالت یک طرفه و دو طرفه تقسیم می‌شوند، استفاده از **الگوی State** مناسب به نظر می‌رسد. این الگو به ما این امکان را می‌دهد که رفتار یک شیء را بر اساس وضعیت داخلی آن تغییر دهیم. 

#### نحوه تحقق الگوی State:
1. ابتدا یک اینترفیس برای حالت‌ها تعریف می‌کنیم که شامل متدهایی است که باید در هر حالت پیاده‌سازی شوند.
2. سپس، برای هر حالت (یک طرفه و دو طرفه) یک کلاس مجزا ایجاد می‌کنیم که این اینترفیس را پیاده‌سازی می‌کند.
3. در نهایت، یک کلاس Context ایجاد می‌کنیم که مسئول نگهداری وضعیت فعلی و تغییر آن در پاسخ به درخواست‌های کاربر است.

برای مثال، کلاس `Context` می‌تواند یک متغیر از نوع اینترفیس حالت‌ها داشته باشد و بسته به وضعیت فعلی (یک طرفه یا دو طرفه)، رفتار مناسب را از طریق فراخوانی متدهای اینترفیس اجرا کند.

### 4. تحلیل اصول SOLID در الگوی طراحی Singleton

- **اصل Single Responsibility**: الگوی Singleton معمولاً یک مسئولیت مشخص دارد و این اصل را رعایت می‌کند. مثلاً مدیریت دسترسی به یک منبع مشترک در سیستم.
- **اصل Open/Closed**: Singleton به طور طبیعی برای توسعه باز نیست، زیرا تنها یک نمونه از کلاس مجاز است. با این حال، می‌توان با استفاده از وراثت یا تغییر متدهای آن، به گسترش آن پرداخت.
- **اصل Liskov Substitution**: این اصل به طور کامل توسط Singleton رعایت نمی‌شود، زیرا تغییر در پیاده‌سازی Singleton ممکن است باعث تغییر در رفتار سیستم شود و نمی‌توان به راحتی آن را جایگزین کرد.
- **اصل Interface Segregation**: الگوی Singleton معمولاً از این اصل پیروی نمی‌کند، زیرا تمرکز آن بیشتر بر مدیریت منابع مشترک است تا تفکیک اینترفیس‌ها.
- **اصل Dependency Inversion**: الگوی Singleton ممکن است باعث وابستگی‌های سنگین در سیستم شود، زیرا کلاس‌های مختلف به آن وابسته هستند، که می‌تواند نقض این اصل باشد.

### 5. توضیح مفاهیم

- **کد تمیز**: کدی که به راحتی قابل خواندن و فهمیدن است، به درستی نام‌گذاری شده و بدون پیچیدگی‌های غیرضروری است.
- **بدهی فنی**: هزینه‌های آینده که به دلیل تصمیمات توسعه‌ای ضعیف یا کوتاه‌مدت در حال حاضر ایجاد می‌شوند و نیاز به اصلاح دارند.
- **بوی بد**: نشانه‌هایی در کد که ممکن است مشکلاتی در طراحی یا پیاده‌سازی آن وجود داشته باشد و نیاز به بازآرایی داشته باشد.

### 6. دسته‌بندی بوهای بد کد

وب‌سایت refactoring.guru بوهای بد کد را به پنج دسته تقسیم می‌کند:

1. **Boilers**: شامل مشکلاتی مانند استفاده بیش از حد از داده‌های ثابت یا تکرار کد.
2. **Bloaters**: کدهایی که به دلیل بزرگی و پیچیدگی زیاد، خوانایی و نگهداری آن‌ها سخت شده است.
3. **Couplers**: کدهایی که وابستگی‌های زیادی به دیگر بخش‌ها دارند و باعث می‌شوند تغییر در یک بخش، نیاز به تغییرات گسترده‌ای در بخش‌های دیگر داشته باشد.
4. **Dispensables**: کدهایی که به نظر غیرضروری می‌آیند و می‌توان آن‌ها را حذف کرد بدون اینکه تأثیر منفی بر عملکرد سیستم بگذارد.
5. **Object-Orientation Abusers**: کدهایی که اصول شیء‌گرایی به درستی در آن‌ها رعایت نشده و منجر به پیچیدگی‌های غیرضروری شده‌اند.

### 7. تحلیل Lazy Class

**Lazy Class** یک بوی بد است که در دسته‌بندی **Dispensables** قرار می‌گیرد. این بو زمانی ایجاد می‌شود که یک کلاس وظایف بسیار کمی دارد و وجود آن ضرورتی ندارد. برای رفع این بو، بازآرایی‌هایی مانند **Inline Class** و **Collapse Hierarchy** توصیه می‌شود. با این حال، اگر پیش‌بینی می‌کنیم که در آینده ممکن است این کلاس گسترش یابد یا وظایف بیشتری به آن اضافه شود، می‌توانیم این بو را نادیده بگیریم.

### 9. پلاگین Formatter و ارتباط آن با بازآرایی کد

پلاگین Formatter کد را به صورت خودکار قالب‌بندی می‌کند تا خوانایی و یکپارچگی کد بهبود یابد. این پلاگین می‌تواند در بازآرایی کد مفید باشد، زیرا با استانداردسازی ظاهر کد، مشکلات و نقاط ضعف آن بهتر قابل شناسایی می‌شوند. علاوه بر این، قالب‌بندی صحیح کد به ما کمک می‌کند تا ساختارهای پیچیده و غیرضروری را شناسایی و ساده‌سازی کنیم.
