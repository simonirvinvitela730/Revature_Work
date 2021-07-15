
public class VarArgs {
	public static void main(String[] args) {
		VarArgs va = new VarArgs();
		va.takeVarArgs("Hello", "Goodbye", "Good Riddance", "A million");
	}
		public void takeArray(String[] words) {
			for(String w : words) {
				System.out.println(w);
			}
		}
		public void takeVarArgs(String... words){
			for  (String w : words) {
				System.out.println(w);
			}
		}
}
