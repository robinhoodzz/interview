package algo_2.$10_trie;

import org.junit.Assert;
import org.junit.Test;

/**
 * 字典树
 * 208
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 示例:
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by Administrator on 2019/9/21.
 */
public class $22_Trie {

    private TrieNode root;

    public $22_Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    @Test
    public void testTrie() throws Exception {

        $22_Trie trie = new $22_Trie();
        trie.insert("apple");
        Assert.assertTrue(trie.search("apple"));   // 返回 true
        Assert.assertFalse(trie.search("app"));     // 返回 false
        Assert.assertTrue(trie.startsWith("app")); // 返回 true
    }

    public void insert(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) {
                ws.children[c - 'a'] = new TrieNode(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    public boolean search(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return true;
    }


    class TrieNode {
        public char val;
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];

        public TrieNode() {
        }

        public TrieNode(char c) {
            TrieNode node = new TrieNode();
            node.val = c;
        }
    }


}
