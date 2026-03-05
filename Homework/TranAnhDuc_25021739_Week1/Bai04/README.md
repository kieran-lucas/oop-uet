# Bài 4 - Tuần 1: Fibonacci

## 1. Ý tưởng chính
- Ta sẽ dùng phương pháp lặp để tính số Fibonacci  
- Trước tiên thì ta vẫn có hai trường hợp cơ sở là `n = 0 -> fib(0) = 0` và `n = 1 -> fib(1) = 1`  
- Và nếu `n < 0` thì trả về `-1` vì `input` không hợp lệ  
- Ta sẽ tạo hai biến là `a, b` tượng trưng cho cặp số đang xét tại một thời điểm, ban đầu nó sẽ có giá trị là `0` và `1`  
- Cứ sau mỗi vòng lặp số thứ nhất sẽ trở thành số thứ hai và số thứ hai sẽ trở thành tổng của hai số
- Ta bắt đầu lặp từ `i = 2` vì số đầu tiên trong vòng lặp là số fibonacci thứ 2, và sau khi lặp đến `i = n` ta trả về `b`, là số fibonacci thứ `n`, tổng cộng ta đã trải qua `n - 1` vòng lặp, mỗi vòng lặp thực hiện các thao tác có độ phức tạp `O(1)` nên tổng độ phức tạp của chương trình là `O(n)`
## 2. Ưu điểm
- Cách tiếp cận này cho ta tốc độ xử lí nhanh hơn nhiều so với việc dùng đệ quy truyền thống vì sẽ có độ phức tạp lên tới `O(2^n)` do mỗi lần tính số fibonacci thứ `n` thì phải tính lại toàn bộ các số trước đó
- Thuật toán này cũng giúp tiết kiệm bộ nhớ vì chỉ dùng một số lượng biến cố định (độ phức tạp bộ nhớ `O(1)`)
## 3. Cách chạy
- Biên dịch chương trình:
```bash
javac Main.java
```
- Chạy chương trình:
```bash
java Main
```

