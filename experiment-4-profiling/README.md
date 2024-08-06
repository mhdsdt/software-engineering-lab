![image](https://github.com/user-attachments/assets/2f4b6c64-9713-4987-a02f-13d6ac3b7385)![image](https://github.com/user-attachments/assets/0c670646-b463-42a8-ba65-a1d3a18c9a4d)# Profiling
 ## نصب yourkit
 
 ابتدا با کمک راهنمایی های داده شده yourkit را نصب کرده و به intellij اضافه میکنیم:
 
 ![image](https://github.com/user-attachments/assets/36b3dc8a-7acd-4f3e-958a-0f29cbeb4013)

![image](https://github.com/user-attachments/assets/e58e1679-c91a-4622-be7a-e6dbb9060bc4)

## پیدا کردن تابع پرمصرف JavaCup

با بررسی کد اولیه ی این کلاس به کمک yourkit میتوانیم تشخیص دهیم پر مصرف ترین قسمت آن مربوط به فراخوانی و اجرای تابع temp میباشد:

![image](https://github.com/user-attachments/assets/c0e65504-2db5-4037-97e3-86109609fb1c)

![image](https://github.com/user-attachments/assets/67bfb215-6300-4c05-9e92-03c31eaa5b42)

![image](https://github.com/user-attachments/assets/1c27950c-8a4c-4a8c-98ab-5fc1e991a2c4)

![image](https://github.com/user-attachments/assets/198eb9bd-0b3e-4d80-a62d-a85203dd3300)

![image](https://github.com/user-attachments/assets/805b5083-30f2-43ab-8622-e43411c3ab4a)

![image](https://github.com/user-attachments/assets/17ff887b-9309-4bad-81ff-ffa7ec2027b5)

![image](https://github.com/user-attachments/assets/2345eba0-b839-4522-a5f7-e30f3b62d8b8)

میتوان تشخیص داد این حجم مصرف منابع به علت استفاده از داده ساختار ArrayList با اندازه ی نامشخص بوده که در هر مرحله باعث ایجاد جدید آن با سایز دوبرابر میشود، برای حل این مشکل چون تعداد تکرار ها در حلقه های تو در تو ثابت است (برابر با 20000 * 10000) میتوانیم بعنوان تغییر اولیه هنگام ایجاد ArrayList این سایز ثابت را به آن بدهیم که نتایح این کار در ادامه امده:

![image](https://github.com/user-attachments/assets/7ccc799e-04c1-4716-98c7-9bad2a699843)

![image](https://github.com/user-attachments/assets/edb806eb-e6bd-47e5-ab02-1af8143540c4)

![image](https://github.com/user-attachments/assets/ab67ac38-a5c2-4638-87a5-c2cfc3eb1ff6)

![image](https://github.com/user-attachments/assets/f2cd80f9-c0ef-486a-bdbc-50e66afa7efd)

در ادامه داده ساختار های مختلف را امتحان میکنیم تا نتایج آن ها را ببینیم:
Primitive Array:

![image](https://github.com/user-attachments/assets/423a71c2-43a4-4599-9a25-03183d6d13c9)

![image](https://github.com/user-attachments/assets/e4f3bd26-cbad-48b7-a51a-79f2c226f5ee)

![image](https://github.com/user-attachments/assets/31432853-01dc-46a3-8f5c-fef07e3d55a7)

![image](https://github.com/user-attachments/assets/8d366ddb-d969-4102-b837-bd6507ef4897)

![image](https://github.com/user-attachments/assets/0005a478-30d0-446d-baad-21b8d0e1428a)

ArrayDeque:

![image](https://github.com/user-attachments/assets/d04e7a68-7afd-4d6b-a04c-f5eaf1b83b2d)

![image](https://github.com/user-attachments/assets/33eba614-55a9-43ba-919a-c01a5a2f8da6)

![image](https://github.com/user-attachments/assets/e29234d2-5fca-4793-9ff3-f2afeb4819c6)

![image](https://github.com/user-attachments/assets/82d45aec-756a-48b7-9e2b-af617399a1dc)

![image](https://github.com/user-attachments/assets/35574ce2-18b9-4b85-9e36-9be5179bdfc2)

که طبق نتایج بالا بهترین حالت استفاده از Primitive Array با سایز ثابت است که در کد نهایی در ریپازیتوری هم نهایتا این مورد آورده شده است.

## نوشتن و اصلاح قطعه کد

در این بخش باید قطعه کدی بنویسیم و آنرا اصلاح کنیم تا منابع کمتری استفاده کند، در ابتدا برای این بخش کد Bubble sort را برای sort کردن آرایه پیاده سازی کرده ایم که مصرف منابع آن در ادامه امده:

![image](https://github.com/user-attachments/assets/74fff96f-33e9-46b8-9b95-051f6f1c2feb)

![image](https://github.com/user-attachments/assets/1dcf6b7c-1ae2-4469-82f6-ed9a4ca7ada2)

![image](https://github.com/user-attachments/assets/fed77ca9-9647-479f-be92-ec2e9f30ddc5)

![image](https://github.com/user-attachments/assets/67e860f8-e8bc-4366-8fb2-273c259bc0fc)

![image](https://github.com/user-attachments/assets/6e651acd-dda4-4cb3-8dc9-516c59b29da4)

برای اصلاح این مصارف الگوریتم sort را به merge sort تغییر میدهیم که نتایج مصرف منابع آن در ادامه امده:

![image](https://github.com/user-attachments/assets/3fcd7ffd-63cf-468d-b01c-55ba185b1855)

![image](https://github.com/user-attachments/assets/1a125bbc-cfd2-4324-8f90-05914b3323f2)

![image](https://github.com/user-attachments/assets/b73be9e5-bc11-4357-84af-d960ba1b5248)

![image](https://github.com/user-attachments/assets/dfa7aed1-044f-4428-ae7a-be820f1c9850)

![image](https://github.com/user-attachments/assets/a3fbb9ea-9a64-4d95-a850-8921c1c9f4e0)




