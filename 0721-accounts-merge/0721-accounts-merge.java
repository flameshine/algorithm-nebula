class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<Integer, Set<String>> emailToAccounts = new HashMap<>();
        Map<String, Integer> emailGroup = new HashMap<>();

        for (var i = 0; i < accounts.size(); i++) {

            var accountId = i;
            var accountDetails = accounts.get(accountId);

            emailToAccounts.computeIfAbsent(accountId, k -> new HashSet<>());

            for (var j = 1; j < accountDetails.size(); j++) {

                var email = accountDetails.get(j);

                if (emailGroup.containsKey(email) && emailGroup.get(email) != accountId) {

                    var previousAccountId = emailGroup.get(email);

                    emailToAccounts.get(accountId).addAll(emailToAccounts.get(previousAccountId));

                    for (var e : emailToAccounts.get(previousAccountId)) {
                        emailGroup.put(e, accountId);
                    }
                }

                emailGroup.put(email, accountId);
                emailToAccounts.get(accountId).add(email);
            }
        }

        emailToAccounts.clear();

        for (var entry : emailGroup.entrySet()) {

            var accountId = entry.getValue();
            var email = entry.getKey();

            emailToAccounts.computeIfAbsent(
                accountId,
                k -> new TreeSet<>((a, b) -> a.compareTo(b))
            );

            emailToAccounts.get(accountId).add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for (var entry : emailToAccounts.entrySet()) {

            var accountId = entry.getKey();
            var emails = entry.getValue();
            var name = accounts.get(accountId).get(0);

            List<String> list = new ArrayList<>();

            list.add(name);
            list.addAll(emails);

            result.add(list);
        }

        return result;
    }
}