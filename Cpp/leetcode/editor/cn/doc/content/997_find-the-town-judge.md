<p>小镇里有 <code>n</code> 个人，按从 <code>1</code> 到 <code>n</code> 的顺序编号。传言称，这些人中有一个暗地里是小镇法官。</p>

<p>如果小镇法官真的存在，那么：</p>

<ol>
	<li>小镇法官不会信任任何人。</li>
	<li>每个人（除了小镇法官）都信任这位小镇法官。</li>
	<li>只有一个人同时满足属性 <strong>1</strong> 和属性 <strong>2</strong> 。</li>
</ol>

<p>给你一个数组 <code>trust</code> ，其中 <code>trust[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> 表示编号为 <code>a<sub>i</sub></code> 的人信任编号为 <code>b<sub>i</sub></code> 的人。</p>

<p>如果小镇法官存在并且可以确定他的身份，请返回该法官的编号；否则，返回 <code>-1</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 2, trust = [[1,2]]
<strong>输出：</strong>2
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 3, trust = [[1,3],[2,3]]
<strong>输出：</strong>3
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>n = 3, trust = [[1,3],[2,3],[3,1]]
<strong>输出：</strong>-1
</pre>
&nbsp;

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
	<li><code>0 &lt;= trust.length &lt;= 10<sup>4</sup></code></li>
	<li><code>trust[i].length == 2</code></li>
	<li><code>trust</code> 中的所有<code>trust[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> <strong>互不相同</strong></li>
	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
	<li><code>1 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt;= n</code></li>
</ul>
<div><div>Related Topics</div><div><li>图</li><li>数组</li><li>哈希表</li></div></div><br><div><li>👍 246</li><li>👎 0</li></div>