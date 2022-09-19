<p>给你一个长度为 <code>n</code> 的数组 <code>words</code> ，该数组由 <strong>非空</strong> 字符串组成。</p>

<p>定义字符串 <code>word</code> 的 <strong>分数</strong> 等于以 <code>word</code> 作为 <strong>前缀</strong> 的 <code>words[i]</code> 的数目。</p>

<ul> 
 <li>例如，如果 <code>words = ["a", "ab", "abc", "cab"]</code> ，那么 <code>"ab"</code> 的分数是 <code>2</code> ，因为 <code>"ab"</code> 是 <code>"ab"</code> 和 <code>"abc"</code> 的一个前缀。</li> 
</ul>

<p>返回一个长度为<em> </em><code>n</code> 的数组<em> </em><code>answer</code><em> </em>，其中<em> </em><code>answer[i]</code><em> </em>是<em>&nbsp;</em><code>words[i]</code> 的每个非空前缀的分数 <strong>总和</strong> <em>。</em></p>

<p><strong>注意：</strong>字符串视作它自身的一个前缀。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>words = ["abc","ab","bc","b"]
<strong>输出：</strong>[5,4,3,2]
<strong>解释：</strong>对应每个字符串的答案如下：
- "abc" 有 3 个前缀："a"、"ab" 和 "abc" 。
- 2 个字符串的前缀为 "a" ，2 个字符串的前缀为 "ab" ，1 个字符串的前缀为 "abc" 。
总计 answer[0] = 2 + 2 + 1 = 5 。
- "ab" 有 2 个前缀："a" 和 "ab" 。
- 2 个字符串的前缀为 "a" ，2 个字符串的前缀为 "ab" 。
总计 answer[1] = 2 + 2 = 4 。
- "bc" 有 2 个前缀："b" 和 "bc" 。
- 2 个字符串的前缀为 "b" ，1 个字符串的前缀为 "bc" 。 
总计 answer[2] = 2 + 1 = 3 。
- "b" 有 1 个前缀："b"。
- 2 个字符串的前缀为 "b" 。
总计 answer[3] = 2 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>words = ["abcd"]
<strong>输出：</strong>[4]
<strong>解释：</strong>
"abcd" 有 4 个前缀 "a"、"ab"、"abc" 和 "abcd"。
每个前缀的分数都是 1 ，总计 answer[0] = 1 + 1 + 1 + 1 = 4 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= words.length &lt;= 1000</code></li> 
 <li><code>1 &lt;= words[i].length &lt;= 1000</code></li> 
 <li><code>words[i]</code> 由小写英文字母组成</li> 
</ul>

<div><li>👍 15</li><li>👎 0</li></div>