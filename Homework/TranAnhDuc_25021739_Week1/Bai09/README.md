# Bài 9 - Tuần 1: Tính tổng chữ số 

## 1. Ý tưởng chính
- Vì bài toán yêu cầu xử lý cả số âm nên nếu `n < 0` ta chuyển `n` thành `-n
- Ta tạo một biến `res` để lưu kết quả
- Ta lần lượt tách từng chữ số cuối của `n` bằng phép chia dư `n % 10`
- Sau đó cộng chữ số vừa lấy được vào biến `res`
- Ta loại bỏ chữ số cuối của `n` bằng phép chia nguyên `n / 10`
- Lặp lại quá trình này cho đến khi `n = 0` ta sẽ được tổng các chữ số
- Thuật toán này có độ phức tạp `O(k)` (`k` là số chữ số)

## 2. Cách chạy
- Biên dịch chương trình:
```bash
javac Main.java
```
- Chạy chương trình:
```bash
java Main
```