package com.example.ortel.tagnet;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.content.Context.ACCESSIBILITY_SERVICE;
import static com.example.ortel.tagnet.MainActivityOld.output1;
import static com.example.ortel.tagnet.MainActivityOld.output2;
import static com.example.ortel.tagnet.MainActivityOld.userInfoHashmap;
import static com.example.ortel.tagnet.Tab1.usersInfoTwo;
import static com.example.ortel.tagnet.Tab3.NoMediaload;
import static com.example.ortel.tagnet.Tab3.load;
import static com.example.ortel.tagnet.Tab3.set;
import static com.example.ortel.tagnet.Tab3.onei;
import static com.example.ortel.tagnet.Tab3.stop;
import static com.example.ortel.tagnet.Tab3.twoi;
import static com.example.ortel.tagnet.Tab3.threei;
import static com.example.ortel.tagnet.Tab3.fouri;

import static com.example.ortel.tagnet.Tab3.fivei;
import static com.example.ortel.tagnet.Tab3.sixi;
import static com.example.ortel.tagnet.Tab3.seveni;
import static com.example.ortel.tagnet.Tab3.eighti;
import static com.example.ortel.tagnet.Tab3.ninei;



public class RelationShipAdapter1 extends BaseAdapter implements Filterable, GetUrls.AsyncResponse {
	public static ArrayList<HashMap<String, String>> usersInfo;
	private ArrayList<HashMap<String, String>> usersInfoOne;
	private ImageView MainImage;
	GetUrls asyncTask =new GetUrls();
	private ItemFilter mFilter = new ItemFilter();
	private LayoutInflater inflater;
	private LayoutInflater inflater1;

	@Override
	public void processFinish(List<String> output) {
		Log.d("OkHttpOutput", String.valueOf(output));
		stop();
		if (Objects.equals(output.get(0), "") && Objects.equals(output.get(1), "") && Objects.equals(output.get(2), "") && Objects.equals(output.get(3), "") && Objects.equals(output.get(4), "") && Objects.equals(output.get(5), "") && Objects.equals(output.get(6), "") && Objects.equals(output.get(7), "") && Objects.equals(output.get(8), "")) {
			//If no media, should no media picture
			NoMediaload();


		}else {
			//See if image is there,if so, add image in gridlayout
			if (!Objects.equals(output.get(0), "")) {
				Picasso.with(context)
						.load(output.get(0))
						.fit().centerCrop()
						.into(onei);
			}
			if (!Objects.equals(output.get(1), "")) {
				Picasso.with(context)
						.load(output.get(1))
						//.fit().centerCrop()
						.fit().centerCrop()

						.into(twoi);
			}
			if (!Objects.equals(output.get(2), "")) {

				Picasso.with(context)
						.load(output.get(2))
						//.fit().centerCrop()
						.fit().centerCrop()

						.into(threei);
			}
			if (!Objects.equals(output.get(3), "")) {

				Picasso.with(context)
						.load(output.get(3))
						//.fit().centerCrop()
						.fit().centerCrop()

						.into(fouri);
			}
			if (!Objects.equals(output.get(4), "")) {


				Picasso.with(context)
						.load(output.get(4))
						//.fit().centerCrop()
						.fit().centerCrop()

						.into(fivei);
			}
			if (!Objects.equals(output.get(5), "")) {

				Picasso.with(context)
						.load(output.get(5))
						//.fit().centerCrop()
						.fit().centerCrop()

						.into(sixi);
			}
			if (!Objects.equals(output.get(6), "")) {

				Picasso.with(context)
						.load(output.get(6))
						//.fit().centerCrop()
						.fit().centerCrop()

						.into(seveni);
			}
			if (!Objects.equals(output.get(7), "")) {

				Picasso.with(context)
						.load(output.get(7))
						//.fit().centerCrop()
						.fit().centerCrop()

						.into(eighti);
			}
			if (!Objects.equals(output.get(8), "")) {
				Picasso.with(context)
						.load(output.get(8))
						//.fit().centerCrop()
						.fit().centerCrop()

						.into(ninei);

			}
		}

	}


	//lvRelationShipAllUser = (ListView) findViewById(R.id.lvRelationShip);
	Context context;

	public RelationShipAdapter1(Context context,
							   ArrayList<HashMap<String, String>> usersInfo, ArrayList<HashMap<String, String>> usersInfoOne) {
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater1 = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		Log.d("OkHttp", "debug4");
		this.context = context;
		this.usersInfo = usersInfo;
		this.usersInfoOne = usersInfoOne;

		//getFilter();
		//originalUsersInfo = (ArrayList<HashMap<String, String>>) usersInfo.clone();


	}

	@Override
	public View getView(final int position, View convertView, final ViewGroup parent) {

		View view = inflater.inflate(R.layout.relationship_inflater, null);
		View Main = inflater.inflate(R.layout.fragment_blank_fragment_two, null);
		View view1 = inflater1.inflate(R.layout.relationship_inflater_nothing, null);
		Log.d("usersInfonlist", String.valueOf(usersInfoTwo.size()));
		Log.d("OkHttpCONTEXT", String.valueOf(context));
		MainImage = (ImageView) Main.findViewById(R.id.ImageProfile);

		final Holder holder = new Holder();
		//Set Images and Username
		holder.ivPhoto = (ImageView) view.findViewById(R.id.ivImage);
		holder.tvFullName = (TextView) view.findViewById(R.id.tvFullName);
		holder.tvFullName.setText(usersInfo.get(position).get(
				"username"));
		Picasso.with(context)
				.load(usersInfo.get(position).get("image"))
				.into(holder.ivPhoto);
		holder.ivPhoto.setTag(context);
		Log.d("UsersInfoTwo", String.valueOf(usersInfoTwo.size()));
		Log.d("UsersInfoTwo", String.valueOf(usersInfoTwo));
		Log.d("UsersInfoTwo1", String.valueOf(holder.tvFullName.getText()));


		//Log.d("OnelikedFour", Four);

		//Log.d("OnelikedFive", Five);




		final int temp = (int) getItem(position);
		view.setOnClickListener(new View.OnClickListener() {

			@SuppressLint("ResourceAsColor")
			@Override
			public void onClick(View view) {
				Log.d("MyApp", "HERE!");
				onei.setImageResource(android.R.color.transparent);
				twoi.setImageResource(android.R.color.transparent);
				threei.setImageResource(android.R.color.transparent);
				fouri.setImageResource(android.R.color.transparent);
				fivei.setImageResource(android.R.color.transparent);
				sixi.setImageResource(android.R.color.transparent);
				seveni.setImageResource(android.R.color.transparent);
				eighti.setImageResource(android.R.color.transparent);
				ninei.setImageResource(android.R.color.transparent);

				asyncTask = new GetUrls();
				AsyncTask(position);
				set(position);
				load();


			}


		});

		return view;
	}

	//Filter with searchView
	@Override
	public Filter getFilter() {
		Log.d("OkHttpNList1", String.valueOf(mFilter));

		return mFilter;

	}
	public void AsyncTask(int i){
		asyncTask.delegate = this;
		asyncTask.execute(new MyTasksParams(output2,usersInfo.get(i).get(
				"username")));

	}

	private class Holder {
		private ImageView ivPhoto;
		private TextView tvFullName;
		private TextView tvFullName1;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return usersInfo.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	//Item Filterer
	private class ItemFilter extends Filter {
		@Override
		protected FilterResults performFiltering(CharSequence constraint) {
			Log.d("OkHttpNList", "here1");
			//MAKE AT THE BEGINING
			String filterString = constraint.toString().toLowerCase();

			FilterResults results = new FilterResults();

			ArrayList<HashMap<String, String>> list = usersInfoOne;

			int count = list.size();
			ArrayList<HashMap<String, String>> nlist = new ArrayList(count);

			String filterableString;
			Log.d("OkHttpNList2", String.valueOf(list));

			for (int i = 0; i < count; i++) {
				filterableString = list.get(i).get("username");
				Log.d("OkHttpNList", String.valueOf(filterableString));


				if (filterableString.toLowerCase().contains(filterString)) {
					nlist.add(list.get(i));
				}
			}
			Log.d("OkHttpNList", String.valueOf(nlist));

			results.values = nlist;


			return results;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void publishResults(CharSequence constraint, FilterResults results) {
			usersInfo = (ArrayList<HashMap<String, String>>) results.values;
			Log.d("OkHttpNList", String.valueOf(usersInfo));
			//Notify Change
			notifyDataSetChanged();
		}

	}

}

