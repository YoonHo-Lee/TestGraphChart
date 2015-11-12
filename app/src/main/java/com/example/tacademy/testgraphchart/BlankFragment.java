package com.example.tacademy.testgraphchart;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dacer.androidcharts.BarView;
import com.dacer.androidcharts.LineView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    public BlankFragment() {
        // Required empty public constructor
    }


    //그래프에 찍히는 갯수
    int randomint = 15;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //루트뷰 선언
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        //그래프 선언
        final LineView lineView = (LineView)rootView.findViewById(R.id.line_view);

        //must*
        //머스트래.....
        ArrayList<String> test = new ArrayList<String>();

        //x축에 표시될 내용
        for (int i=0; i<randomint; i++){
            test.add(String.valueOf(i+1));
        }
        lineView.setBottomTextList(test);


        //그래프 내의 x축을 도트로 표시
        lineView.setDrawDotLine(true);

        //누르면 수치 표시되는거같음
        lineView.setShowPopup(LineView.SHOW_POPUPS_NONE);

        Button lineButton = (Button)rootView.findViewById(R.id.line_button);
        lineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                randomSet(lineView);

            }
        });

        randomSet(lineView);
        return rootView;
    }

    //그래프 수치 랜덤셋팅

    //ArrayList에 더미 온도 값 넣기.
    private void randomSet(LineView lineView){
        ArrayList<Integer> dataList = new ArrayList<Integer>();
        int random = (int)(Math.random()*9+1);
        for (int i=0; i<randomint; i++){
            dataList.add((int)(Math.random()*random)*92);
        }

        ArrayList<Integer> dataList2 = new ArrayList<Integer>();
        random = (int)(Math.random()*9+1);
        for (int i=0; i<randomint; i++){
            dataList2.add((int)(Math.random()*random)*33);
        }

        ArrayList<Integer> dataList3 = new ArrayList<Integer>();
        random = (int)(Math.random()*9+1);
        for (int i=0; i<randomint; i++){
            dataList3.add((int)(Math.random()*random)*77);
        }

        //ArrayList에 있는 데이터를 그래프 데이터인 DataLists에 넣는다.
        ArrayList<ArrayList<Integer>> dataLists = new ArrayList<ArrayList<Integer>>();
        dataLists.add(dataList);
        dataLists.add(dataList2);
        dataLists.add(dataList3);

        //그래프 데이터를 그래프에 출력
        lineView.setDataList(dataLists);
    }
}