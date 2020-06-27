package digipodium.recyclerview_ex_1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    List<String> countries = new ArrayList<String>();
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        countries.add("India");
        countries.add("France");
        countries.add("Canada");
        countries.add("Sweden");
        countries.add("Argentina");
        countries.add("Afganistan");
        countries.add("Bahamas");
        countries.add("South Korea");
        countries.add("Hawaii");
        countries.add("Greece");
        countries.add("Mauritius");
        countries.add("Sri lanka");
        countries.add("Switzerland");
        countries.add("Kyrgyztan");
        countries.add("Japan");
        countries.add("Egypt");
        countries.add("Germany");
        countries.add("England");
        countries.add("China");
        countries.add("Netherlands");
        countries.add("Maldives");
        countries.add("Iceland");
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView countryRv=view.findViewById(R.id.countryRv);
        countryRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        CountryAdapter adapter= new CountryAdapter(getActivity(), R.layout.row_country, countries);
        countryRv.setAdapter(adapter);
    }

    class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.Holder>{
        private final Context context;
        private final int layout;
        private final List<String> countries;
        private final LayoutInflater inflater;

        // constructor
        public CountryAdapter(Context context, int layout, List<String> countries) {
            this.context = context;
            this.layout = layout;
            this.countries = countries;
            inflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = inflater.inflate(layout, parent, false);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            String countryName = countries.get(position);
            holder.textCountry.setText(countryName);
        }

        @Override
        public int getItemCount() {
            return countries.size();
        }

        class Holder extends RecyclerView.ViewHolder{

            TextView textCountry;

            public Holder(@NonNull View itemView) {
                super(itemView);
                textCountry = itemView.findViewById(R.id.textCountry);
            }
        }
    }
}