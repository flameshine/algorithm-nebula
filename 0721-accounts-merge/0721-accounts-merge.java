class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<Integer, Set<String>> emailToAccounts = new HashMap<>();
        Map<String, Integer> emailGroup = new HashMap<>();

        for (var i = 0; i < accounts.size(); i++) {

            var accountDetails = accounts.get(i);

            emailToAccounts.computeIfAbsent(i, k -> new TreeSet<>(String::compareTo));

            for (var j = 1; j < accountDetails.size(); j++) {

                var email = accountDetails.get(j);

                if (emailGroup.containsKey(email) && emailGroup.get(email) != i) {

                    var previousAccountId = emailGroup.get(email);
                    var previousEmails = emailToAccounts.get(previousAccountId);

                    emailToAccounts.get(i).addAll(previousEmails);

                    for (var e : previousEmails) {
                        emailGroup.put(e, i);
                    }

                    emailToAccounts.remove(previousAccountId);

                } else {
                    emailGroup.put(email, i);
                    emailToAccounts.get(i).add(email);
                }
            }
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