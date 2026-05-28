class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];

        // Best index for this suffix
        int index = -1;
        int len = Integer.MAX_VALUE;
    }

    TrieNode root = new TrieNode();

    // Update best candidate
    private void update(TrieNode node, int idx, int length) {
        if (length < node.len || 
           (length == node.len && idx < node.index)) {

            node.len = length;
            node.index = idx;
        }
    }

    // Insert reversed word into trie
    private void insert(String word, int idx) {

        TrieNode node = root;

        update(node, idx, word.length());

        for (int i = word.length() - 1; i >= 0; i--) {

            int c = word.charAt(i) - 'a';

            if (node.children[c] == null) {
                node.children[c] = new TrieNode();
            }

            node = node.children[c];

            update(node, idx, word.length());
        }
    }

    // Find best matching suffix
    private int search(String word) {

        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {

            int c = word.charAt(i) - 'a';

            if (node.children[c] == null) {
                break;
            }

            node = node.children[c];
        }

        return node.index;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        // Build trie
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        // Process queries
        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }
}