# Bài 10 - Tuần 1: Tìm số lớn thứ 2 trong mảng
## 1. Ý tưởng chính
- Trước hết nếu mảng rỗng hoặc có số phần tử bé hơn 2 thì trả về `-1` vì khi đó sẽ không có số lớn thứ 2 trong mảng
- Ta sẽ thiết lập hai biến là `max` và `second` tượng trưng cho số lớn nhất và số lớn thứ `2` đã từng thấy 
- Ban đầu do chưa thấy số nào nên ta khởi tạo hai biến có giá trị là số nhỏ nhất của kiểu số nguyên
- Tiếp theo ta duyệt từng phần tử của mảng, nếu phần tử đó lớn hơn `max` thì bây giờ `max` sẽ trở thành số lớn thứ `2` từng được nhìn thấy, và phần tử đó sẽ trở thành `max` mới
- Nếu mà phần tử đó nằm giữa `max` và `second` thì phần tử này sẽ trở thành số lớn thứ 2 từng được nhìn thấy và ta gán lại `second` bằng phần tử này
- Cứ tiếp tục như vậy cho đến khi duyệt hết mảng
- Khi đã duyệt hết mảng mà không không tìm thấy số lớn thứ hai (ta kiểm tra bằng `foundSecond`) thì trả về `-1`
- Độ phức tạp của thuật toán này là `O(n)`
## 2. Cách chạy
- Biên dịch chương trình:
```bash
javac Main.java
```
- Chạy chương trình:
```bash
java Main
```