#!/bin/bash
echo "
=============================================
-- Welcome to changelog installer --
=============================================
"
echo "Enter the repository URL: "
read repository 
echo "\n---- Init node ----\n" 
npm init -y
echo "\n---- Download dependencies ----\n" 
npm i --save-dev husky standard-version npm-add-script commitizen cz-conventional-changelog devmoji 
npx husky install
npx husky add .husky/prepare-commit-msg "npx devmoji -e --lint"
npx npmAddScript -k postinstall -v "husky install"
npx npmAddScript -k release -v "standard-version"
npx npmAddScript -k release:minor -v "standard-version --release-as minor"
npx npmAddScript -k release:patch -v "standard-version --release-as patch"
npx npmAddScript -k release:major -v "standard-version --release-as major"
echo 'node_modules'>> .gitignore
echo '{ "path": "cz-conventional-changelog" }'>> .czrc
echo "{
  "\"header"\": "\"Changelog"\",
  "\"types"\": [
    {"\"type"\": "\"feat"\", "\"section"\": "\"✨ Features"\"},
    {"\"type"\": "\"fix"\", "\"section"\": "\"🐛 Bug Fixes"\"},
    {"\"type"\": "\"chore"\", "\"section"\": "\"🚚 Chores"\","\"hidden"\": false},
    {"\"type"\": "\"docs"\", "\"section"\": "\"📝 Documentation"\","\"hidden"\": false},
    {"\"type"\": "\"ci"\", "\"section"\": "\"👷 CI/CD"\","\"hidden"\": false},
    {"\"type"\": "\"build"\", "\"section"\": "\"📦️ Configurations"\","\"hidden"\": false},
    {"\"type"\": "\"style"\", "\"section"\": "\"💄 Styling"\","\"hidden"\": false},
    {"\"type"\": "\"refactor"\", "\"section"\": "\"♻️ Code Refactoring"\","\"hidden"\": false},
    {"\"type"\": "\"perf"\", "\"section"\": "\"⚡️ Performance Improvements"\","\"hidden"\": false},
    {"\"type"\": "\"test"\", "\"section"\": "\"✅ Testing"\","\"hidden"\": false}
  ],
  "\"commitUrlFormat"\": "\"$repository/commit/{{hash}}"\",
  "\"compareUrlFormat"\": "\"$repository/compare/{{previousTag}}...{{currentTag}}"\",
  "\"issuePrefixes"\": ["\"#"\"],
  "\"issueUrlFormat"\": "\"$repository/issues/{{id}}"\"
}">> .versionrc.json
