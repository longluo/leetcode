package com.longluo.leetcode.design;

/**
 * 535. TinyURL 的加密与解密
 * <p>
 * TinyURL是一种URL简化服务， 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，
 * 它将返回一个简化的URL http://tinyurl.com/4e9iAk.
 * <p>
 * 要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。你的加密和解密算法如何设计和运作是没有限制的，
 * 你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。
 * <p>
 * https://leetcode-cn.com/problems/encode-and-decode-tinyurl/
 */
public class Problem535_encodeAndDecodeTinyurl {

    public class Codec {

        private int MOD = 128;
        private int OFFSET = 36;

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            int len = longUrl.length();
            StringBuilder sb = new StringBuilder(len);
            for (char ch : longUrl.toCharArray()) {
                sb.append((char) ((ch + OFFSET) % MOD));
            }

            return sb.toString();
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            int len = shortUrl.length();
            StringBuilder sb = new StringBuilder(len);
            for (char ch : shortUrl.toCharArray()) {
                sb.append((char) ((ch + MOD - OFFSET) % MOD));
            }

            return sb.toString();
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.decode(codec.encode(url));

    public static void main(String[] args) {

    }
}
