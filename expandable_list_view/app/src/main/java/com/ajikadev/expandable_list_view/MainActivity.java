package com.ajikadev.expandable_list_view;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ExpandableListActivity {

  private ExpandableListAdapter expandableListAdapter;
  private List<Map<String, String>> listDataHeader;
   private List<List<Map<String, String>>> listDataChild;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Prepare data for the expandable list
    prepareListData();

    // Initialize the expandable list adapter
    expandableListAdapter = new SimpleExpandableListAdapter(this, listDataHeader,
      android.R.layout.simple_expandable_list_item_1, new String[]{"header"},
      new int[]{android.R.id.text1}, listDataChild,
      android.R.layout.simple_expandable_list_item_2,
      new String[]{"child"},
      new int[]{android.R.id.text1}
    );

    // Set adapter to expandable list view
    setListAdapter(expandableListAdapter);
  }

  // Prepare data for expandable list
  private void prepareListData() {
    listDataHeader = new ArrayList<>();
    listDataChild = new ArrayList<>();

    // Adding header data
    Map<String, String> header1 = new HashMap<>();
    header1.put("header", "Mancity");
    listDataHeader.add(header1);

    Map<String, String> header2 = new HashMap<>();
    header2.put("header", "Arsenal");
    listDataHeader.add(header2);

    Map<String, String> header3 = new HashMap<>();
    header3.put("header", "Liverpool");
    listDataHeader.add(header3);

    // Adding child data
    List<Map<String, String>> mancity = new ArrayList<>();
    addChild(mancity, "Doku");
    addChild(mancity, "KDB");
    addChild(mancity, "Ake");
    listDataChild.add(mancity);

    List<Map<String, String>> liverpool = new ArrayList<>();
    addChild(liverpool, "Salah");
    addChild(liverpool, "Nunez");
    addChild(liverpool, "Gakpo");
    listDataChild.add(liverpool);

    List<Map<String, String>> arsenal = new ArrayList<>();
    addChild(arsenal, "Gabriel");
    addChild(arsenal, "Jesus");
    addChild(arsenal, "Nketiah");
    listDataChild.add(arsenal);
  }

  // Helper method to add child item to the list
  private void addChild(List<Map<String, String>> list, String item) {
    Map<String, String> map = new HashMap<>();
    map.put("child", item);
    list.add(map);
  }
}
