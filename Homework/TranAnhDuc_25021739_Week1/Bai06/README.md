# Bài 6 - Tuần 1: Kiểm tra số nguyên tố
## 1. Ý tưởng chính
- Ta sẽ duyệt từ `2` cho đến số mà có bình phương bé hơn hoặc bằng `n`, nếu tồn tại một số mà `n` chia hết thì ta kết luận nó không phải là số nguyên tố
- Khi ta xét một số `n`, giữa 2 và trung bình nhân của nó `√n` và giữa `√n` và n sẽ có các cặp ước tương ứng nhau, nên nếu có 1 ước trong khoảng này thì cũng sẽ có một ước tương ứng trong khoảng kia.
## 2. Ưu điểm
- Việc chỉ duyệt đến trung bình nhân của `n` giúp ta cải thiện độ phức tạp thời gian của thuật toán thành `O(√n)` thay vì `O(n)` nếu ta duyệt hết
## 3. Cách chạy
- Biên dịch chương trình:
```bash
javac Main.java
```
- Chạy chương trình:
```bash
java Main
```
