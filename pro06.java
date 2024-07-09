ㅇㅇㅇㅇㅇㅇㅇㅇ
			}
			user -= failcnt[i];
		}

		percent = Arrays.stream(percent).boxed().sorted(Collections.reverseOrder()).mapToDouble(Double::doubleValue)
				.toArray();

		return percent;

	}
}
