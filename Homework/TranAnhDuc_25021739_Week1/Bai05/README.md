# Bài 5 - Tuần 1: Xây dựng ước số chung lớn nhất
## 1. Ý tưởng chính
- Ta sẽ tìm ước số chung lớn nhất của hai số nguyên bằng thuật toán `Euclid`, dựa trên tính chất sau:
    `gcd(a, b) = gcd(b, a % b)`
- Ta sẽ lặp lại phép toán này cho đến khi `b = 0` vì khi đó `gcd(a, 0) = a`
- Và do đó nếu ban đầu `b = 0` ta có thể trả về `a` ngay luôn
## 2. Chứng minh công thức Euclid
Giả sử:

`a = qb + r`, với `r = a mod b`

Ta chứng minh:

`gcd(a, b) = gcd(b, r)`

Nếu `d` là ước chung của `a` và `b`:

`d | a`, `d | b`  
`⇒ d | (a − qb)`  
`⇒ d | r`

`⇒ d | b`, `d | r`  
`⇒ d` là ước chung của `(b, r)`

Ngược lại, nếu `d` là ước chung của `b` và `r`:

`d | b`, `d | r`  
`⇒ d | (qb + r)`  
`⇒ d | a`

`⇒ d | a`, `d | b`  
`⇒ d` là ước chung của `(a, b)`

Vì tập ước chung của `(a, b)` và `(b, r)` giống nhau nên:

`gcd(a, b) = gcd(b, r)`

Vì tập ước chung của `(a, b)` và `(b, r)` giống nhau:

gcd(a, b) = gcd(b, r)
## 3. Ưu điểm
- Thuật toán này có độ phức tạp `O(log(n))` nhanh hơn nhiều so với cách dùng vòng lặp (ta thực hiện một vòng lặp ngược để tìm ra số lớn nhất mà vừa được `a` chia hết và `b` chia hết, nó có độ phức tạp là `O(n)`)
## 4. Cách chạy
- Biên dịch chương trình:
```bash
javac Main.java
```
- Chạy chương trình:
```bash
java Main
```

