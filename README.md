### Реализуйте ApplicationComponent
Это корень нашего дерева компонентов. Инициализируется в классе App, прокидывает в граф через Component Dependencies/Subcomponents ниже по графу следующие сущности:
- `Context(Application)` до `ProducerFragmentComponent` и `ReceiverFragmentComponent`. 
Проброс Context в граф реализуйте через BindsInstance + ComponentFactory

### Реализуйте MainActivityComponent
Инициализируется в `MainActivity`. Прокидывает следующие сущности:
- `Context(Activity)`. Проброс в граф реализуйте через `BindsInstance` + `ComponentFactory`
- Ваша реализация обсервера(Coroutine Channel/StateFlow/Subject либо другую реализацию обсервера). Он понадобится нам чтобы отправлять евенты из одного фрагмента и принимать их в другом, в обоих фрагментах должен быть один и тот же инстанс обсервера.

### Реализуйте ReceiverFragmentComponent/ProducerFragmentComponent
- Коммуникацию между Producer и Receiver осуществите через канал/StateFlow/Subject либо другую реализацию обсервера которая уже есть в графе.
- `ProducerViewModel` должна отправлять ивенты, `ReceiverViewModel` должна получать эвенты.
- Обсерверы должны прокидываться в конструкторы вьюмоделей и существовать в единственном экземпляре в `Activity`.

Флоу отправки эвента выглядит следующим образом: Клик на кнопку button в `ProducerFragment` -> вызов метода вьюмодели -> проброс ивента в обсервер -> евент ловится на стороне `ReceiverViewModel` -> евент передается `ReceiverFragment` и вызывается функция `ru.otus.daggerhomework.ReceiverFragment#populateColor`
