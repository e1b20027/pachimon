パチモン セットアップマニュアル

～サーバのアクセス～
1.isdev-bash....exeを起動し、「ssh isdev22@150.89.233.207」コマンドでサーバにアクセスする。
2.パスワード「isDev22?207」を入力する。

～タイムゾーンの変更～
1.dateコマンド、timedatectlコマンドを用いて、現在のタイムゾーンの設定を行う。
具体的には、「sudo timedatectl set-timezone Asia/Tolyo」コマンド実行後、「timedatectl」を実行する。

～Webアプリケーションの公開～
1.ホームディレクトリに移動するため、「cd」コマンドを入力。また移動後「pwd」コマンドで、移動を確認する。
2.「git clone https://github.com/e1b20027/pachimon.git」コマンドを実行し、クローンする。必要であれば、「ls」コマンドで確認する。
3.「cd pachimon」コマンドで、リポジトリに移動する。

～アプリケーションの実行～
1.「bash ./gradlew」コマンドを実行して実行する。
2.「bash ./gradlew bootrun」コマンドでプロジェクトを実行する。
3.「http://150.89.233.207」で対象のURLにアクセスし、ゲームログイン画面に移る。
