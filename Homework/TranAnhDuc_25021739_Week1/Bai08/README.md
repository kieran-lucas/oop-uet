# Bài 8 - Tuần 1: Kiểm tra số Palindrome
## 1. Ý tưởng chính
- Một số nguyên `n` được gọi là đối xứng (palindrome) nếu khi đảo ngược thứ tự các chữ số của nó ta vẫn thu được chính nó
- Nếu `n < 0` thì chắc chắn không phải số đối xứng vì dấu `-` chỉ xuất hiện ở đầu số
- Ta tái sử dụng hàm `reverse(n)` đã viết Bài 7 để đảo ngược số `n`
- Nếu `n == reverse(n)` thì `n` là số đối xứng, ngược lại thì không phải

## 2. Cách chạy
- Biên dịch chương trình:
```bash
javac Main.java
```
- Chạy chương trình:
```bash
java Main
```