package com.devs.android_cleanarch_mvp.domain.interactor;

import android.text.PrecomputedText;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Deven on 2019-10-04.
 */
@RunWith(MockitoJUnitRunner.class)
public class UseCaseTest {


    private UseCaseTestClass useCase;
    private TestDisposableObserver<Object> testObserver;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setup(){
        useCase = new UseCaseTestClass();
        testObserver = new TestDisposableObserver<>();
    }

//    @Test
//    public void testBuildUseCaseObservableReturnCorrectResult(){
//        useCase.execute(testObserver, Params.EMPTY);
//        assertThat(testObserver.valuesCount).isZero();
//    }

//    @Test
//    public void testSubscriptionWhenExecutingUseCase() {
//        useCase.execute(testObserver, Params.EMPTY);
//        useCase.dispose();
//
//        assertThat(testObserver.isDisposed()).isTrue();
//    }

//    @Test
//    public void testShouldFailWhenExecuteWithNullObserver() {
//        expectedException.expect(NullPointerException.class);
//        useCase.execute(null, Params.EMPTY);
//    }

    private static class UseCaseTestClass extends UseCase<Object, Params> {
        UseCaseTestClass(){
            super();
        }
        @Override
        Observable<Object> buildUseCaseObservable(Params params) {
            return Observable.empty();
        }

        @Override
        public void execute(DisposableObserver<Object> observer, Params params) {
            super.execute(observer, params);
        }
    }

    private static class TestDisposableObserver<T> extends DisposableObserver<T> {
        private int valuesCount = 0;

        @Override public void onNext(T value) {
            valuesCount++;
        }

        @Override public void onError(Throwable e) {
            // no-op by default.
        }

        @Override public void onComplete() {
            // no-op by default.
        }
    }

    private static class Params {
        private static Params EMPTY = new Params();
        private Params() {}
    }


}
