package io.github.ypsitau.examplejson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.google.gson.Gson;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

	public static class Person {
		public String name;
		public int age;
		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return String.format("Person(name=%s,age=%s)", name, age);
		}
	}
	enum Job {
		Teacher, Doctor, Businessman,
	};
	public static class Worker {
		public String name;
		public int age;
		public Job job;
		public Worker(String name, int age, Job job) {
			this.name = name;
			this.age = age;
			this.job = job;
		}

		@Override
		public String toString() {
			return String.format("Worker(name=%s,age=%s,job=%s)", name, age, job.name());
		}
	}

	public static class Composite {
		public int[] nums;
		public Person[] people;
		public Worker[] workers;

		@Override
		public String toString() {
			return String.format("Composite(nums=%s,people=%s,workers=%s)",
				Arrays.toString(nums), Arrays.toString(people), Arrays.toString(workers));
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		App.setLogEditText((EditText)findViewById(R.id.editText_log), false);
		Gson gson = new Gson();
		Moshi moshi = new Moshi.Builder().build();
		JsonAdapter<int[]> jsonAdapter_intArray = moshi.adapter(int[].class);
		JsonAdapter<String[]> jsonAdapter_StringArray = moshi.adapter(String[].class);
		JsonAdapter<Person[]> jsonAdapter_PersonArray = moshi.adapter(Person[].class);
		JsonAdapter<Worker[]> jsonAdapter_WorkerArray = moshi.adapter(Worker[].class);
		JsonAdapter<Composite> jsonAdapter_Composite = moshi.adapter(Composite.class);
		{
			int[] org = {
					3, 1, 4, 1, 5, 9, 2, 6
			};
			String str;
			App.printf("------------------------\n");
			App.printf("Gson: %s\n", str = gson.toJson(org));
			App.printf("Moshi: %s\n", jsonAdapter_intArray.toJson(org));
			{
				App.printf("\nGson Restored(int[]):\n");
				int[] res = gson.fromJson(str, int[].class);
				App.printf("%s\n", Arrays.toString(res));
			}
			{
				App.printf("\nMoshi Restored(int[]):\n");
				try {
					int[] res = jsonAdapter_intArray.fromJson(str);
					App.printf("%s\n", Arrays.toString(res));
				} catch (Exception e) {
					App.printf("%s\n", e.getMessage());
				}
			}
			{
				App.printf("\nGson Restored(String[]):\n");
				String[] res = gson.fromJson(str, String[].class);
				App.printf("%s\n", Arrays.toString(res));
			}
			{
				App.printf("\nMoshi Restored(String[]):\n");
				try {
					String[] res = jsonAdapter_StringArray.fromJson(str);
					App.printf("%s\n", Arrays.toString(res));
				} catch (Exception e) {
					App.printf("%s\n", e.getMessage());
				}
			}
		}
		{
			String[] org = {
					"apple", "grape", "banana", "strawberry", "pineapple"
			};
			String str;
			App.printf("------------------------\n");
			App.printf("Gson: %s\n", str = gson.toJson(org));
			App.printf("Moshi: %s\n", str = jsonAdapter_StringArray.toJson(org));
			{
				App.printf("\nGson Restored(int[]):\n");
				try {
					int[] res = gson.fromJson(str, int[].class);
					App.printf("%s\n", Arrays.toString(res));
				} catch (Exception e) {
					App.printf("%s\n", e.getMessage());
				}
			}
			{
				App.printf("\nMoshi Restored(int[]):\n");
				try {
					int[] res = jsonAdapter_intArray.fromJson(str);
					App.printf("%s\n", Arrays.toString(res));
				} catch (Exception e) {
					App.printf("%s\n", e.getMessage());
				}
			}
			{
				App.printf("\nGson Resotred(String[]):\n");
				String[] res = gson.fromJson(str, String[].class);
				App.printf("%s\n", Arrays.toString(res));
			}
			{
				App.printf("\nMoshi Restored(String[]):\n");
				try {
					String[] res = jsonAdapter_StringArray.fromJson(str);
					App.printf("%s\n", Arrays.toString(res));
				} catch (Exception e) {
					App.printf("%s\n", e.getMessage());
				}
			}
		}
		{
			Person[] org = {
					new Person("Takahashi", 24),
					new Person("Nagano", 27),
					new Person("Yamashita", 22),
					new Person("Suzuki", 25),
			};
			String str;
			App.printf("------------------------\n");
			App.printf("Gson: %s\n", str = gson.toJson(org));
			App.printf("Moshi: %s\n", str = jsonAdapter_PersonArray.toJson(org));
			{
				App.printf("\nGson Restored(Person[]):\n");
				Person[] res = gson.fromJson(str, Person[].class);
				App.printf("%s\n", Arrays.toString(res));
			}
			{
				App.printf("\nMoshi Restored(Person[]):\n");
				try {
					Person[] res = jsonAdapter_PersonArray.fromJson(str);
					App.printf("%s\n", Arrays.toString(res));
				} catch (Exception e) {
					App.printf("%s\n", e.getMessage());
				}
			}
			{
				App.printf("\nGson Restored(int[]):\n");
				try {
					int[] res = gson.fromJson(str, int[].class);
					App.printf("%s\n", Arrays.toString(res));
				} catch (Exception e) {
					App.printf("%s\n", e.getMessage());
				}
			}
			{
				App.printf("\nMoshi Restored(int[]):\n");
				try {
					int[] res = jsonAdapter_intArray.fromJson(str);
					App.printf("%s\n", Arrays.toString(res));
				} catch (Exception e) {
					App.printf("%s\n", e.getMessage());
				}
			}
			{
				App.printf("\nGson Restored(Worker[]):\n");
				try {
					Worker[] res = gson.fromJson(str, Worker[].class);
					App.printf("%s\n", Arrays.toString(res));
				} catch (Exception e) {
					App.printf("%s\n", e.getMessage());
				}
			}
			{
				App.printf("\nMoshi Restored(Worker[]):\n");
				try {
					Worker[] res = jsonAdapter_WorkerArray.fromJson(str);
					App.printf("%s\n", Arrays.toString(res));
				} catch (Exception e) {
					App.printf("%s\n", e.getMessage());
				}
			}
		}
		{
			Composite org = new Composite();
			org.nums = new int[]{
					3, 1, 4, 1, 5, 9, 2, 6
			};
			org.people = new Person[]{
					new Person("Takahashi", 24),
					new Person("Nagano", 27),
					new Person("Yamashita", 22),
					new Person("Suzuki", 25),
			};
			org.workers = new Worker[]{
					new Worker("Gamo", 23, Job.Teacher),
					new Worker("Ando", 23, Job.Doctor),
			};
			String str;
			App.printf("------------------------\n");
			App.printf("Gson: %s\n", str = gson.toJson(org));
			App.printf("Moshi: %s\n", str = jsonAdapter_Composite.toJson(org));
			{
				App.printf("\nRestored(Composite):\n");
				Composite res = gson.fromJson(str, Composite.class);
				App.printf("%s\n", res.toString());
			}
			{
				App.printf("\nMoshi Restored(Composite):\n");
				try {
					Composite res = jsonAdapter_Composite.fromJson(str);
					App.printf("%s\n", res.toString());
				} catch (Exception e) {
					App.printf("%s\n", e.getMessage());
				}
			}
		}
	}
}
