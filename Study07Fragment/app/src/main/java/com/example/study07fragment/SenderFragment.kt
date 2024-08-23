package com.example.study07fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.study07fragment.databinding.FragmentSenderBinding
import androidx.fragment.app.setFragmentResult // 직접 추가

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SenderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

/*
    p.343
      <프래그먼트 생명주기>
      - onAttach -> onCreate -> onCreateView -> onViewCreated
        -> onStart -> onResume -> onPause -> onStop -> onDestroy

      <백스택(back stack)> : 프래그먼트가 화면에 보이지 않는 순간 제거하지 않고 저장했다가 다시 사용할 수 있는 기능
      - 백스택을 이용하면 사용자가 뒤로가기 버튼을 누를 때 이전 프래그먼트로 화면을 전환할 수 있음
      - 백스택을 사용하지 않으면 프래그먼트가 교체될 때 기존의 프래그먼트는 onDestroy까지 호출되어 제거됨
*/

class SenderFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding : FragmentSenderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_sender, container, false)

        binding = FragmentSenderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.btnYes.setOnClickListener {
            val bundle = bundleOf("valueKey" to "yes")
            setFragmentResult("request", bundle)
        }

        binding.btnNo.setOnClickListener {
            val bundle = bundleOf("valueKey" to "no")
            setFragmentResult("request", bundle)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SenderFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SenderFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}