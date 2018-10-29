package leavesc.hello.retrofit2_rxjava2.http.repo;

import android.arch.lifecycle.MutableLiveData;

import leavesc.hello.retrofit2_rxjava2.http.basis.BaseRepo;
import leavesc.hello.retrofit2_rxjava2.http.basis.callback.RequestCallback;
import leavesc.hello.retrofit2_rxjava2.http.datasource.base.IWeatherDataSource;
import leavesc.hello.retrofit2_rxjava2.model.Weather;

/**
 * 作者：leavesC
 * 时间：2018/10/27 21:12
 * 描述：
 * GitHub：https://github.com/leavesC
 * Blog：https://www.jianshu.com/u/9df45b87cfdf
 */
public class WeatherRepo extends BaseRepo<IWeatherDataSource> {

    public WeatherRepo(IWeatherDataSource remoteDataSource) {
        super(remoteDataSource);
    }

    public MutableLiveData<Weather> queryWeather(String cityName) {
        MutableLiveData<Weather> weatherMutableLiveData = new MutableLiveData<>();
        remoteDataSource.queryWeather(cityName, new RequestCallback<Weather>() {
            @Override
            public void onSuccess(Weather weather) {
                weatherMutableLiveData.setValue(weather);
            }
        });
        return weatherMutableLiveData;
    }

}
