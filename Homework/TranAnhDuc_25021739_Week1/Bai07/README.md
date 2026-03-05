# Bài 7 - Tuần 1: Đảo ngược số nguyên
## 1. Ý tưởng chính
- Trước hết ta tạo một biến res (result) để lưu kết quả, ban đầu có giá trị bằng `0`
- Ta sẽ tách từng chữ số ngoài cùng của `n` sau đó lại gán vào `res`
- Rồi cắt đi chữ số ngoài cùng của `n` bằng cách `/ 10` để chuẩn bị cho lần tiếp theo
- Ta lại lấy chữ số ngoài của của `n` hiện tại (thực chất là số thứ `2` ngoài cùng của `n` ban đầu) để gán vào đằng sau `res` bằng cách `res * 10 + digit`, `digit` là chữ số ngoài cùng vừa lấy được
- Ta cứ lặp lại như vậy cho đến khi `n = 0`
- Do phép lấy dư của Java hoạt động đúng với số âm nên ta không cần quan tâm phần này
- Để tránh trường hợp tràn số, trước khi gán `res` giá trị mới, ta sẽ kiểm tra gián tiếp bằng `(res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10)`, đoạn code này sẽ giúp ta phát hiện tràn số một cách gián tiếp thông qua `res * 10`
- Độ phức tạp của thuật toán này là `O(k)`

## . Cách chạy
- Biên dịch chương trình:
```bash
javac Main.java
```
- Chạy chương trình:
```bash
java Main
```
