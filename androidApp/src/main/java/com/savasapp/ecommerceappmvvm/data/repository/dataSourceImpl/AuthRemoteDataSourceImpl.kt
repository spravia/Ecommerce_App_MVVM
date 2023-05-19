import com.savasapp.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.savasapp.ecommerceappmvvm.data.service.AuthService
import com.savasapp.ecommerceappmvvm.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authService: AuthService) : AuthRemoteDataSource {

    override suspend fun login(email : String, password : String) = authService.login(email, password)
}