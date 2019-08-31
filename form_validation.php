<?php

$config=[
			'login_rules' => [
										[
											'field' => 'email',
											'label' => 'Email ID',
											'rules' => 'trim|required|valid_email'
										],
										[
											'field' => 'password',
											'label' => 'Password',
											'rules' => 'required'
										]
									],

			'signup_rules' =>[
										[
											'field' => 'first_name',
											'label' => 'First Name',
											'rules' => 'required|alpha_numeric_spaces'
										],
										[
											'field' => 'last_name',
											'label' => 'Last Name',
											'rules' => 'required|alpha_numeric_spaces'
										],
										[
											'field' => 'email',
											'label' => 'Email ID',
											'rules' => 'trim|required|valid_email'
										],
										[
											'field' => 'password',
											'label' => 'Password',
											'rules' => 'required'
										],
										[
											'field' => 'phone',
											'label' => 'Phone Number',
											'rules' => 'required'
										],					
							]
];