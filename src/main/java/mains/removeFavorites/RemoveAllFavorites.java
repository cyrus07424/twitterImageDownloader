package mains.removeFavorites;

import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import utils.Twitter4jHelper;

/**
 * 全てのお気に入りを削除.
 *
 * @author cyrus
 */
public class RemoveAllFavorites {

	/**
	 * main.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// Twitter4jを取得
			Twitter twitter = Twitter4jHelper.getTwitter4j();

			// 結果が空になるまで繰り返す
			List<Status> statusList;
			while (!(statusList = twitter.getFavorites()).isEmpty()) {
				// 全てのお気に入りに対して実行
				for (Status status : statusList) {
					System.out.println(status);
					try {
						// お気に入りを削除
						twitter.destroyFavorite(status.getId());
					} catch (TwitterException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
}