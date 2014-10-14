/**
 * @file
 * @par File Name:
 * Ex07.java
 * @author budougumi0617
 * @date Created on 2014/10/09
 */
package main.java.ch2.ex07;

import java.util.stream.Stream;

/**
 * @author budougumi0617
 * @note 上司が、メソッドとして public static <T> boolean
 *       isFinite( Stream<T>stream)を
 *       作成するように求めています。 それは、よくない考えでしょうか。
 *       まずは作成してみてから、考えてみなさい。
 *       解答：
 *       入力ストリームが無限であるか検証するのはよくない考えである。
 *       無限ストリームであることは、
 *       「ストリームが有限時間で処理できない」かどうかで判断するしかない。
 */
public class Ex07 {

	public static class VaridateStream<T> implements Runnable {
		private Stream<T> stream;
		private boolean timeUp = false;
		private boolean finite = false;
		private static final int LIMIT_TIME = 1000;

		/**
		 * 入力ストリームへの終端操作がLIMIT_TIME以内に終了するか確認する
		 * 
		 * @param stream
		 *            検証するストリーム
		 */
		public VaridateStream(Stream<T> stream) {
			this.stream = stream;
		}

		public boolean isTimeUp() {
			return timeUp;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			long start = System.currentTimeMillis();
			stream.forEach(c -> {
				if (System.currentTimeMillis() > start + LIMIT_TIME) {
					timeUp = true;
					setFinite(false);
					return;
				}
			});
			timeUp = true;
			setFinite(true);
		}

		/**
		 * @return the finite
		 */
		public boolean isFinite() {
			return finite;
		}

		/**
		 * @param finite
		 *            the finite to set
		 */
		private void setFinite(boolean finite) {
			this.finite = finite;
		}

	}

	/**
	 * Finite...限界のある、限定された、限りある、有限の
	 * 入力ストリームに対する処理がVaridateStream
	 * .LIMIT_TIME以内に終了した場合、 入力ストリームは有限ストリームとみなす。
	 */
	public static <T> boolean isFinite(Stream<T> stream) {
		VaridateStream<T> vs = new VaridateStream<T>(stream);
		new Thread(vs).start();
		while (!(vs.isTimeUp())) {
			System.out.println("isTimeUp = " + vs.isTimeUp());
		}
		return vs.isFinite();
	}

	public static void main(String[] args) {
		Stream<String> finiteStream = Stream.generate(() -> "test");// .limit(10);
		System.out.println("stream is finite : " + Ex07.isFinite(finiteStream));
	}

}
